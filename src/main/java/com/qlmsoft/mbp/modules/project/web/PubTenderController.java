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
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;
import com.qlmsoft.mbp.modules.project.service.TenderInfoService;

/**
 * 项目安监申报Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubTenderController extends BaseController {

	@Autowired
	private TenderInfoService tenderInfoService;

	@RequestMapping(value = "/publicity/projectdetailtender")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<TenderInfo> tenderList = tenderInfoService.findListByProjectPkid(pkid);
		model.addAttribute("tenderList", tenderList);
		return "modules/publicity/ProjectDetailTender";
	}

}