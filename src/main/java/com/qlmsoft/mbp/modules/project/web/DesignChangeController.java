/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
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
 * 重大设计变更Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
@RequestMapping(value = "/publicity/designchange")
public class DesignChangeController extends BaseController {

	@Autowired
	private PubApproveResultService pubApproveResultService;

	@RequestMapping("")
	public String list(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("designchange"));
 
		return "modules/publicity/DesignChange";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String list(PubApproveResult approveResult,
			HttpServletRequest request, HttpServletResponse response) {
		approveResult.setDisplayFlag("4");
		List<PubApproveResult> approves = pubApproveResultService
				.findList(approveResult);
		DataTableBean<PubApproveResult> result = new DataTableBean<PubApproveResult>();

		if (approves != null && !approves.isEmpty()) {
			result.setData(approves);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

}