package com.qlmsoft.mbp.modules.crawler.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.modules.crawler.service.ApproveResultCrawler;
import com.qlmsoft.mbp.modules.project.bean.ResultBean;
import com.qlmsoft.mbp.modules.project.service.PubApproveResultService;

@Controller
@RequestMapping(value = "${adminPath}/crawler/approveresult")
public class ApproveResultCrawlerController {

	@Autowired
	private PubApproveResultService approveResultService;

	@Autowired
	private ApproveResultCrawler crawler;

	@RequestMapping("synchall")
	@ResponseBody
	public String synchall(HttpServletRequest request,
			HttpServletResponse response) {

		ResultBean result = new ResultBean();
		try {
			crawler.synchAll();
		} catch (Exception e) {
			result.setCode(ResultBean.ERROR);
			result.setMsg(e.getMessage());
		}
		return JsonMapper.getInstance().toJson(result);

	}

	@RequestMapping("synchsingle")
	@ResponseBody
	public String synchsingle(HttpServletRequest request,
			HttpServletResponse response) {

		String prjName = request.getParameter("PrjName");
		ResultBean result = new ResultBean();
		ApplyProjectInfo prj = new ApplyProjectInfo();
		prj.setProjectName(prjName);
		try {
			crawler.synchByPrjName(prj);
		} catch (Exception e) {
			result.setCode(ResultBean.ERROR);
			result.setMsg(e.getMessage());
		}

		return JsonMapper.getInstance().toJson(result);

	}
}
