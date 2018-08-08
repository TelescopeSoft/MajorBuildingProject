/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目表Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "/publicity/applyprojects")
public class ApplyProjectController extends BaseController {

	@Autowired
	private ApplyProjectInfoService service;


	@RequestMapping(value = "")
	public String list(ApplyProjectInfo projectInfo, HttpServletRequest request,
					   HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("index"));
		model.addAttribute("projectinfo", projectInfo);
		return "modules/publicity/Index";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String projects(ApplyProjectInfo projectInfo, HttpServletRequest request,
			HttpServletResponse response) {

//		projectInfo.setMajorFlag(Constant.IS_MAJOR_PROJECT);
//		projectInfo.setAllinvest(new BigDecimal(5000));
		List<ApplyProjectInfo> list = service.findList(projectInfo);
		DataTableBean<ApplyProjectInfo> result = new DataTableBean<ApplyProjectInfo>();
		result.setData(list);
		if (list != null && !list.isEmpty()) {
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}



}