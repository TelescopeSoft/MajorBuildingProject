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
import com.qlmsoft.mbp.modules.project.entity.ContractRecord;
import com.qlmsoft.mbp.modules.project.service.ContractRecordService;

/**
 * 项目合同备案Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubContractRecordController extends BaseController {

	@Autowired
	private ContractRecordService contractRecordService;

	@RequestMapping(value = "/publicity/projectdetailcontract")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<ContractRecord> list = contractRecordService
				.findListByProjectPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailContract";
	}

}