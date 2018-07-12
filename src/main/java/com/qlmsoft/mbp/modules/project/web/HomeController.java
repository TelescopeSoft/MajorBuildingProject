/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlmsoft.mbp.common.config.Constant;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
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

	@RequestMapping(value = "index")
	public String list(ProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		model.addAttribute("projectinfo", projectInfo);
		return "modules/publicity/Index";
	}

	@RequestMapping(value = "projects")
	@ResponseBody
	public String projects(ProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response) {

//		projectInfo.setMajorFlag(Constant.IS_MAJOR_PROJECT);
		List<ProjectInfo> list = tBProjectInfoService.findList(projectInfo);
		DataTableBean<ProjectInfo> result = new DataTableBean<ProjectInfo>();
		result.setData(list);
		return JsonMapper.getInstance().toJson(result);
	}

}