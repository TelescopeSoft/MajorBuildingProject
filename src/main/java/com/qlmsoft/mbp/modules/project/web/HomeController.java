/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlmsoft.mbp.common.config.Constant;
import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.PubApproveGuide;
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import com.qlmsoft.mbp.modules.project.service.PubApproveGuideService;
import com.qlmsoft.mbp.modules.project.service.PubApproveResultService;
import com.qlmsoft.mbp.modules.project.service.TBProjectInfoService;

/**
 * 项目表Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "/publicity")
public class HomeController extends BaseController {

	@Autowired
	private TBProjectInfoService tBProjectInfoService;

	@Autowired
	private PubApproveGuideService pubApproveGuideService;

	@Autowired
	private PubApproveResultService pubApproveResultService;

	@RequestMapping(value = "index")
	public String list(ProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("index"));
		model.addAttribute("projectinfo", projectInfo);
		return "modules/publicity/Index";
	}

	@RequestMapping(value = "projects")
	@ResponseBody
	public String projects(ProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response) {

//		projectInfo.setMajorFlag(Constant.IS_MAJOR_PROJECT);
//		projectInfo.setAllinvest(new BigDecimal(5000));
		List<ProjectInfo> list = tBProjectInfoService.findList(projectInfo);
		DataTableBean<ProjectInfo> result = new DataTableBean<ProjectInfo>();
		result.setData(list);
		if (list != null && !list.isEmpty()) {
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

	@RequestMapping(value = "projectdetail")
	public String projectdetail(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String id = request.getParameter("pkid");
		ProjectInfo projectInfo = tBProjectInfoService.get(id);
		model.addAttribute("projectinfo", projectInfo);
		// model.addAttribute("menuList",
		// PulicityMenuInstance.getMenus("index"));
		return "modules/publicity/ProjectDetail";
	}

	@RequestMapping(value = "projectdetailbasic")
	public String detailBasic(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		ProjectInfo projectinfo = tBProjectInfoService.get(pkid);
		model.addAttribute("projectinfo", projectinfo);
		return "modules/publicity/ProjectDetailBasic";
	}

	@RequestMapping(value = "projectdetailapprove")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<PubApproveResult> list = pubApproveResultService
				.findListByPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailApprove";
	}

	@RequestMapping(value = "approveguide")
	public String approveguide(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		PubApproveGuide pubApproveGuide = new PubApproveGuide();
		Page<PubApproveGuide> page = pubApproveGuideService.findPage(
				new Page<PubApproveGuide>(request, response), pubApproveGuide);

		model.addAttribute("page", page);
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("approveguide"));

		return "modules/publicity/Guide";
	}

	@RequestMapping(value = "landexpropriation")
	public String landexpropriation(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("landexpropriation"));

		return "modules/publicity/LandExpropriation";
	}

}