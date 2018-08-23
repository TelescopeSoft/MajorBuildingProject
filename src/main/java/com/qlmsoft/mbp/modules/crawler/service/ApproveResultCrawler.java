package com.qlmsoft.mbp.modules.crawler.service;

import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.bean.PubApproveResultTable;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import com.qlmsoft.mbp.modules.project.service.PubApproveResultService;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ApproveResultCrawler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static Pattern APPROVE_NUM_PATTERN = Pattern
			.compile("(?<type>.*?)[\\[|【|(|（](?<year>\\d{4})[\\]|】|)|）](?<num>\\d{1,4})");

	public static final String APPROVE_RESULT_QUERY_URL = "http://218.94.123.37/tzxmspweb/portalopenPublicInformation.do?method=queryExamineAll";

	public static Pattern TOTAL_PAGE_PATTERN = Pattern
			.compile("(?<=共&nbsp;&nbsp;)[^&nbsp;&nbsp;页]+");
	public static Pattern TOTAL_NUM_PATTERN = Pattern
			.compile("(?<=页&nbsp;&nbsp;)[^条&nbsp;&nbsp;记录]+");

	@Autowired
	PubApproveResultService approveResultService;

	public CloseableHttpClient closeHttpClient = null ; // HttpClients.createDefault();

	public void synchAll() {

	}

	/**
	 * 按项目名 抓取第一页
	 * @param prj
	 * @throws IOException
	 */
	public boolean synchByPrjName(ApplyProjectInfo prj) throws IOException {

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        boolean result = true;
		CloseableHttpResponse httpResponse = null;
		HttpPost httpPost = new HttpPost(APPROVE_RESULT_QUERY_URL);

		// 设置Post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("apply_project_name", prj.getProjectCode()));
		httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));


		try {

			httpResponse = closeHttpClient.execute(httpPost);
			String html = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");

			/**
			 * String html = null; InputStream is = new FileInputStream(
			 * "E:\\2018\\滨湖区重大项目建设项目\\数据源\\江苏省投资项目在线审批监管平台\\Approve.html");
			 * html = StreamUtils.InputStreamTOString(is);
			 */
			if (html != null) {
				PubApproveResultTable approveResult = getApproveResultTable(prj.getProjectCode(),
						html);
                if(approveResult != null && approveResult.getList() != null  && !approveResult.getList().isEmpty()){
                    result = true;
                    for (PubApproveResult i : approveResult.getList()) {
                        //i.setPrjNum(prj.getPrjnum());
                        approveResultService.checkDuplicatedAndSave(i);
                    }
                }

			}

			// } catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			// throw e;
			// } catch (ClientProtocolException e) {
			// e.printStackTrace();
			// throw e;
		} catch (IOException e) {
            result =false;
			e.printStackTrace();
			throw e;
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return result;

	}

	/**
	 * 第一页数据提取
	 * 
	 * @param prjCode
	 * @param html
	 * @return
	 */
	private PubApproveResultTable getApproveResultTable(String prjCode,
			String html) {
		logger.info("===========getApproveResultTable for prjCode : " + prjCode);

		PubApproveResultTable result = new PubApproveResultTable();

		List<PubApproveResult> list = new ArrayList<PubApproveResult>();
		Document doc = Jsoup.parse(html);

		try {

			// 获取分页信息
			Element pageDiv = doc.select("div.flright div.qmanu").first();
			String pageStr = pageDiv.html();

			logger.debug("pageStr : " + pageStr);

			Matcher m = TOTAL_PAGE_PATTERN.matcher(pageStr);

			while (m.find()) {
				logger.debug("total page : " + m.group());
				result.setTotalPage(Integer.parseInt(m.group().trim()));
			}

			Matcher m2 = TOTAL_NUM_PATTERN.matcher(pageStr);
			while (m2.find()) {
				logger.debug("total record : " + m2.group());
				result.setTotalRecord(Integer.parseInt(m2.group().trim()));
			}

			Element pageSize = doc.getElementById("pageSize");
			result.setPageSize(Integer.parseInt(pageSize.val()));

			Element pageNo = doc.getElementById("pageNo");
			result.setPageNo(Integer.parseInt(pageNo.val()));

			// 获取当前页记录信息
			abstractApproveList(list, doc);

			// 遍历分页记录
			if (result.getTotalPage() > 1) {
				// 有分页，计算分页
				logger.info("total record : " + result.getTotalRecord()
						+ " - totalpage:" + result.getTotalPage()
						+ " - pagesize:" + result.getPageSize());

				// 抓取分页数据
				for (int i = 2; i <= result.getTotalPage(); i++) {

					List<PubApproveResult> approveInPage = getApproveResultTableByPage(
							prjCode, i, result.getPageSize());
					if (approveInPage != null && !approveInPage.isEmpty()) {
						list.addAll(approveInPage);
					}
					Thread.sleep(10 * 1000l);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		result.setList(list);
		if (result.getList().isEmpty()) {
			logger.info("list is null");
		} else {
			for (PubApproveResult vo : result.getList()) {
				logger.info(vo.toString());
			}
		}

		return result;

	}

	/**
	 * 抓取分页页面
	 * 
	 * @param prjName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public List<PubApproveResult> getApproveResultTableByPage(String prjName,
			int pageNo, int pageSize) throws IOException, ParseException {
		logger.debug("getApproveResultTableByPage : " + pageNo);
		List<PubApproveResult> list = new ArrayList<PubApproveResult>();
		CloseableHttpResponse httpResponse = null;
		HttpPost httpPost = new HttpPost(APPROVE_RESULT_QUERY_URL);

		// 设置Post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("apply_project_name", prjName));
		params.add(new BasicNameValuePair("pageSize", Integer
				.toString(pageSize)));
		params.add(new BasicNameValuePair("pageNo", Integer.toString(pageNo)));
		httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

		try {
			if(closeHttpClient == null){
				RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
				closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
			}
			httpResponse = closeHttpClient.execute(httpPost);
			String html = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");
			if (html != null) {
				Document doc = Jsoup.parse(html);
				abstractApproveList(list, doc);
				logger.debug("list : " + list.size());
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return list;
	}

	/**
	 * 提取数据方法
	 * 
	 * @param list
	 * @param doc
	 * @throws ParseException
	 */
	private void abstractApproveList(List<PubApproveResult> list, Document doc)
			throws ParseException {
		Elements trs = doc.select("div.flright ul table tr");
		int currentSize = 0;
		for (Element tr : trs) {
			++currentSize;
			// 第一行为表格标题
			if (currentSize > 1) {
				PubApproveResult r = new PubApproveResult();
				Elements tds = tr.getElementsByTag("td");

				if (tds.size() == 7) {
					String codeAndNameStr = tds.get(0).attr("title").trim();
					int pos = codeAndNameStr.indexOf("]") + 1;
					String code = codeAndNameStr.substring(pos, pos + 24);// 24位项目代码
					String name = codeAndNameStr.substring(pos + 24);

					r.setPrjCode(code);
					r.setPrjName(name);

					// 审批事项
					r.setApproveItemLabel(tds.get(1).attr("title"));

					// 审批部门
					r.setApproveDept(tds.get(2).html());
					// 区划
					r.setCounty(tds.get(3).html());

					// 审批结果
					r.setApproveResult(tds.get(4).html());

					// 批复文号
					r.setApproveNum(tds.get(5).attr("title"));
                    if(!StringUtils.isEmpty(r.getApproveNum())){
                        Matcher matcher = APPROVE_NUM_PATTERN.matcher(r.getApproveNum());
                        while (matcher.find()) {
                            r.setApproveNumType(matcher.group("type"));
                            r.setApproveNumYear(matcher.group("year"));
                            r.setApproveNumNum(matcher.group("num"));
                        }
                    }

					// 审批时间
					r.setApproveDate(DateUtils.parseDate(tds.get(6).html(),
							"yyyy/MM/dd"));
					logger.debug("====" + r.toString());
					list.add(r);

				}

			}

		}
	}

}
