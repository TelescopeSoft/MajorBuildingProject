/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;
import com.qlmsoft.mbp.modules.project.entity.Expropriation;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetail;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetailInfo;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbService;
import com.qlmsoft.mbp.modules.project.service.ExpropriationDetailService;
import com.qlmsoft.mbp.modules.project.service.ExpropriationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 土地征收Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-25
 */
@Controller
public class PubExpropriationController extends BaseController {

	@Autowired
	private ExpropriationService expropriationService;

	@Autowired
	private ExpropriationDetailService detailService;

	@RequestMapping(value = "/publicity/expropriationinfodetail")
	public String detail(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String lcid = request.getParameter("lcid");

		ExpropriationDetail detail = detailService.getByLcid(lcid);
		model.addAttribute("detail", detail);

		model.addAttribute("menuList", PulicityMenuInstance.getMenus("expropriationinfo"));
		return "modules/publicity/ExpropriationInfoDetail";
	}

	@RequestMapping("/publicity/expropriationinfo")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("expropriationinfo"));

		return "modules/publicity/ExpropriationInfo";
	}

	@RequestMapping("/publicity/expropriationinfo/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		Expropriation display = new Expropriation();
		List<Expropriation> list = expropriationService.findList(display);
		DataTableBean<Expropriation> result = new DataTableBean<Expropriation>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

	//征地告知书
	@RequestMapping("/publicity/expropriationnotice")
	public String expropriationnotice(HttpServletRequest request,
					   HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("expropriationnotice"));

		return "modules/publicity/ExpropriationNotice";
	}

	@RequestMapping("/publicity/expropriationnotice/list")
	@ResponseBody
	public String noticeList(HttpServletRequest request, HttpServletResponse response) {
		List<ExpropriationDetailInfo> list = detailService.getNotice();
		DataTableBean<ExpropriationDetailInfo> result = new DataTableBean<ExpropriationDetailInfo>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

	//征收土地公告
	@RequestMapping("/publicity/landannouncement")
	public String landannouncement(HttpServletRequest request,
									  HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("landannouncement"));

		return "modules/publicity/LandAnnouncement";
	}

	@RequestMapping("/publicity/landannouncement/list")
	@ResponseBody
	public String landannouncementList(HttpServletRequest request, HttpServletResponse response) {
		List<ExpropriationDetailInfo> list = detailService.getAnnouncement();
		DataTableBean<ExpropriationDetailInfo> result = new DataTableBean<ExpropriationDetailInfo>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}
	//安置补偿方案公告
	@RequestMapping("/publicity/compensationplan")
	public String compensationplan(HttpServletRequest request,
								   HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("landannouncement"));

		return "modules/publicity/CompensationPlan";
	}

	@RequestMapping("/publicity/compensationplan/list")
	@ResponseBody
	public String compensationplanList(HttpServletRequest request, HttpServletResponse response) {
		List<ExpropriationDetailInfo> list = detailService.getCompensationplan();
		DataTableBean<ExpropriationDetailInfo> result = new DataTableBean<ExpropriationDetailInfo>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

}