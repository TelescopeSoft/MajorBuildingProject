/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import com.qlmsoft.mbp.modules.project.service.ApproveItemInfoService;
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
@RequestMapping(value = "/publicity/approveresult2")
public class ApproveResult2Controller extends BaseController {

	@Autowired
	private ApproveItemInfoService approveItemInfoService;

	@RequestMapping("")
	public String list(ApproveItemInfo approveResult,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("approveresult2"));
		model.addAttribute("approveresult", approveResult);
		return "modules/publicity/ApproveResult2";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String list(ApproveItemInfo approveResult,
			HttpServletRequest request, HttpServletResponse response) {
//		logger.info("---- approve result list------"
//				+ approveResult.toString());
//		approveResult.setDisplayFlag("0");
		List<ApproveItemInfo> approves = approveItemInfoService
				.findList(approveResult);
		DataTableBean<ApproveItemInfo> result = new DataTableBean<ApproveItemInfo>();

		if (approves != null && !approves.isEmpty()) {
			result.setData(approves);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

}