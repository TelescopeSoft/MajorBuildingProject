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

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;
import com.qlmsoft.mbp.modules.project.service.ProjectFinishService;

/**
 * 项目安监申报Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubProjectFinishController extends BaseController {

	@Autowired
	private ProjectFinishService finishService;

	@RequestMapping(value = "/publicity/projectdetailfinish")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<ProjectFinish> list = finishService.findListByProjectPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailFinish";
	}
	
	@RequestMapping("/publicity/finish")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("finish"));

		return "modules/publicity/Finish";
	}

	@RequestMapping("/publicity/finish/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		ProjectFinish display = new ProjectFinish();
		List<ProjectFinish> list = finishService.findList(display);
		DataTableBean<ProjectFinish> result = new DataTableBean<ProjectFinish>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}

	}

}