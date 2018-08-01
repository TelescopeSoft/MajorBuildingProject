/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.ConstructInfoBean;
import com.qlmsoft.mbp.modules.project.bean.ConstructInfoDwBean;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbService;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbDwryService;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbService;

/**
 * 项目施工有关信息Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
public class PubConstructionController extends BaseController {

	@Autowired
	private ApZjsbbService zjsbService;

	@Autowired
	private ApAjsbbService ajsbService;

	@Autowired
	private ApZjsbbDwryService zjsbDwryService;

	@RequestMapping(value = "/publicity/projectdetailconstruction")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String pkid = request.getParameter("pkid");
		List<ConstructInfoBean> result = new ArrayList<ConstructInfoBean>();

		List<ApZjsbb> zjsbList = zjsbService.findListByProjectPkid(pkid);
		if (zjsbList != null && !zjsbList.isEmpty()) {
			for (ApZjsbb i : zjsbList) {
				ConstructInfoBean info = new ConstructInfoBean();
				info.setXmmc(i.getXmmc());
				info.setUuid(i.getUuid());

				ApZjsbbDwry apZjsbbDwry = new ApZjsbbDwry();
				apZjsbbDwry.setUuid(i.getUuid());
				List<ApZjsbbDwry> dwryList = zjsbDwryService
						.findList(apZjsbbDwry);
				
				//处理身份证号码
				/**
				if(dwryList != null && !dwryList.isEmpty()){
					for(ApZjsbbDwry ry: dwryList){
						ry.setIdcard(ry.getIdcard().substring(0, 10) + "******" + ry.getIdcard().substring(16, 18));
						ry.setLxdh(ry.getLxdh().substring(0, 7) + "******" );
					}
				}*/

				fillConstructInfo(info, dwryList);

				result.add(info);

			}
		}

		model.addAttribute("list", result);
		return "modules/publicity/ProjectDetailConstruction";
	}

	private void fillConstructInfo(ConstructInfoBean info,
			List<ApZjsbbDwry> dwryList) {

		// 获取建设单位
		ApZjsbbDwry jsdwRy = getByDwlxAndGw("建设单位", "现场负责人", dwryList);
		if (jsdwRy != null) {
			info.setJsdwName(jsdwRy.getCorpname());
			info.getJsdwRyList().add(jsdwRy);
		}

		// 勘察单位
		ApZjsbbDwry kcDwRy = getByDwlxAndGw("勘察单位", "项目负责人", dwryList);
		if (kcDwRy != null) {
			ConstructInfoDwBean kcdw = new ConstructInfoDwBean();
			kcdw.setDwName(kcDwRy.getCorpname());
			kcdw.setDwlx(kcDwRy.getDwlx());
			kcdw.getDwRyList().add(kcDwRy);
			info.getDwList().add(kcdw);
		}

		// 设计单位
		ApZjsbbDwry sjDwRy = getByDwlxAndGw("设计单位", "项目负责人", dwryList);
		if (sjDwRy != null) {
			ConstructInfoDwBean sjdw = new ConstructInfoDwBean();
			sjdw.setDwName(sjDwRy.getCorpname());
			sjdw.setDwlx(sjDwRy.getDwlx());
			sjdw.getDwRyList().add(sjDwRy);
			info.getDwList().add(sjdw);
		}

		// 施工单位
		ApZjsbbDwry sgDwRy = getByDwlxAndGw("施工单位", "项目经理", dwryList);
		if (sgDwRy != null) {
			ConstructInfoDwBean sgdw = new ConstructInfoDwBean();
			sgdw.setDwName(sgDwRy.getCorpname());
			sgdw.setDwlx(sgDwRy.getDwlx());
			sgdw.getDwRyList().add(sgDwRy);
			info.getDwList().add(sgdw);
		}

		// 监理单位
		ApZjsbbDwry jlDwRy = getByDwlxAndGw("监理单位", "项目总监", dwryList);
		if (jlDwRy != null) {
			ConstructInfoDwBean jldw = new ConstructInfoDwBean();
			jldw.setDwName(jlDwRy.getCorpname());
			jldw.setDwlx(jlDwRy.getDwlx());
			jldw.getDwRyList().add(jlDwRy);
			info.getDwList().add(jldw);
		}

	}

	/**
	 * 按单位类型获取岗位人员
	 * 
	 * @param dwlx
	 * @param dwryList
	 * @return
	 */
	private List<ApZjsbbDwry> getByDwlx(String dwlx, List<ApZjsbbDwry> dwryList) {
		List<ApZjsbbDwry> result = new ArrayList<ApZjsbbDwry>();
		for (ApZjsbbDwry i : dwryList) {
			if (i.getDwlx().equals(dwlx)) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * 按单位类型，岗位获取单位人员
	 * 
	 * @param dwlx
	 * @param dwryList
	 * @return
	 */
	private ApZjsbbDwry getByDwlxAndGw(String dwlx, String gw,
			List<ApZjsbbDwry> dwryList) {
		ApZjsbbDwry result = null;

		for (ApZjsbbDwry i : dwryList) {
			if (i.getDwlx().equals(dwlx) && i.getGw().equals(gw)) {
				result = i;
				break;
			}
		}
		return result;
	}

}