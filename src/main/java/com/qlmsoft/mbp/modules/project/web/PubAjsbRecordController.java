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
import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbService;

/**
 * 项目安监申报Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubAjsbRecordController extends BaseController {

	@Autowired
	private ApAjsbbService ajsbbService;

	@RequestMapping(value = "/publicity/projectdetailsafty")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<ApAjsbb> list = ajsbbService.findListByProjectPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailSafty";
	}

	@RequestMapping("/publicity/safty")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("safty"));

		return "modules/publicity/Safty";
	}

	@RequestMapping("/publicity/safty/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		ApAjsbb display = new ApAjsbb();
		List<ApAjsbb> list = ajsbbService.findList(display);
		DataTableBean<ApAjsbb> result = new DataTableBean<ApAjsbb>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}

	}
}