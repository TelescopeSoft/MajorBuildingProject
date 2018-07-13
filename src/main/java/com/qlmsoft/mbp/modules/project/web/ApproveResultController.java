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
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import com.qlmsoft.mbp.modules.project.service.PubApproveResultService;

/**
 * 项目表Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "/publicity/approveresult")
public class ApproveResultController extends BaseController {

	@Autowired
	private PubApproveResultService pubApproveResultService;

	@RequestMapping("")
	public String list(PubApproveResult approveResult,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("approveresult"));
		model.addAttribute("approveresult", approveResult);
		return "modules/publicity/ApproveResult";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String list(PubApproveResult approveResult,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("---- approve result list------" + approveResult.toString());
		List<PubApproveResult> approves = pubApproveResultService
				.findList(approveResult);
		DataTableBean<PubApproveResult> result = new DataTableBean<PubApproveResult>();
		result.setData(approves);
		return JsonMapper.getInstance().toJson(result);
	}

}