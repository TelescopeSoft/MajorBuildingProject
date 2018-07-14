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

import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbService;

/**
 * 项目质监申报Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubZjsbRecordController extends BaseController {

	@Autowired
	private ApZjsbbService zjsbbService;

	@RequestMapping(value = "/publicity/projectdetailquality")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<ApZjsbb> list = zjsbbService.findListByProjectPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailQuality";
	}

}