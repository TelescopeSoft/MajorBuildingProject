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
import com.qlmsoft.mbp.modules.project.entity.PubAdminPenalty;
import com.qlmsoft.mbp.modules.project.service.PubAdminPenaltyService;

/**
 * 行政处罚Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
@RequestMapping(value = "/publicity/adminpenalty")
public class AdminPenaltyController extends BaseController {

	@Autowired
	private PubAdminPenaltyService adminPenaltyService;

	@RequestMapping("")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("adminpenalty"));

		return "modules/publicity/AdminPenalty";
	}

	@RequestMapping(value = "list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {

		PubAdminPenalty display = new PubAdminPenalty();
		display.setDisplayFlag("0");
		List<PubAdminPenalty> list = adminPenaltyService.findList(display);
		DataTableBean<PubAdminPenalty> result = new DataTableBean<PubAdminPenalty>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}

	}

	@RequestMapping("detail")
	public String detail(HttpServletRequest request,
					   HttpServletResponse response, Model model) {
		String id = request.getParameter("id");

		PubAdminPenalty bean = adminPenaltyService.get(id);
		model.addAttribute("menuList",
				PulicityMenuInstance.getMenus("adminpenalty"));
		model.addAttribute("bean", bean);
		return "modules/publicity/AdminPenaltyDetail";
	}

}