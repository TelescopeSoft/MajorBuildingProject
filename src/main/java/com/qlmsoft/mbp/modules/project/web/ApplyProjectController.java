/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.*;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;
import com.qlmsoft.mbp.modules.project.service.ApproveItemInfoService;
import com.qlmsoft.mbp.modules.project.service.PubConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 项目表Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "/publicity/project")
public class ApplyProjectController extends BaseController {

	@Autowired
	private ApplyProjectInfoService service;

	@Autowired
	private ApproveItemInfoService approveService;

	@Autowired
	PubConfigService configService;

	@RequestMapping(value = "")
	public String list(ApplyProjectInfo projectInfo, HttpServletRequest request,
					   HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("project"));
		model.addAttribute("projectinfo", projectInfo);
		return "modules/publicity/Project";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String projects(ApplyProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response) {

//		projectInfo.setMajorFlag(Constant.IS_MAJOR_PROJECT);
		PubConfig config = configService.getByKey("total_money");
		if(config == null){
			projectInfo.setTotalMoney(new BigDecimal(5000l));
		}else {
			projectInfo.setTotalMoney(new BigDecimal(config.getCvalue()));
		}


		projectInfo.setApplyDateStart("2017-08-01");
		projectInfo.setApplyDateEnd(DateUtils.formatDate(new Date(),"yyyy-MM-dd"));
		//projectInfo.setProjectNature("0");
		projectInfo.setProjectType("A00001,A00002");

		List<ApplyProjectInfo> list = service.findList(projectInfo);
		DataTableBean<ApplyProjectInfo> result = new DataTableBean<ApplyProjectInfo>();
		result.setData(list);
		if (list != null && !list.isEmpty()) {
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

	@RequestMapping(value = "detail")
	public String detail(HttpServletRequest request,
								HttpServletResponse response, Model model) {
		String projectCode = request.getParameter("projectCode");
		ApplyProjectInfo projectInfo = service.getByProjectCode(projectCode);
		model.addAttribute("projectinfo", projectInfo);
		// model.addAttribute("menuList",
		// PulicityMenuInstance.getMenus("index"));
		return "modules/publicity/ProjectDetail";
	}

	@RequestMapping(value = "detailbasic")
	public String detailBasic(HttpServletRequest request,
							  HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		ApplyProjectInfo projectInfo = service.getByProjectCode(pkid);
		model.addAttribute("projectinfo", projectInfo);
		return "modules/publicity/ProjectDetailBasic";
	}

	@RequestMapping(value = "detailapprove")
	public String detailApprove(HttpServletRequest request,
								HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		ApproveItemInfo approveItem = new ApproveItemInfo();
		approveItem.setProjectCode(pkid);
		List<ApproveItemInfo> list = approveService.findList(approveItem);
		if(list != null) {
			logger.info("list.size() :" + list.size());
		}
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailApprove";
	}



}