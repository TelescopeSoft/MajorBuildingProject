/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlmsoft.mbp.modules.project.entity.PubConfig;
import com.qlmsoft.mbp.modules.project.service.PubConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;
import com.qlmsoft.mbp.modules.project.service.ProjectBuilderLicenceService;

/**
 * 施工许可信息Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubBuildLicenseController extends BaseController {

	@Autowired
	private ProjectBuilderLicenceService buildLicenseService;
	@Autowired
	PubConfigService configService;

	@RequestMapping(value = "/publicity/projectdetailbuildlicense")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<ProjectBuilderLicence> list = buildLicenseService
				.findListByProjectPkid(pkid);
		model.addAttribute("list", list);
		return "modules/publicity/ProjectDetailBuildLicense";
	}

	@RequestMapping("/publicity/construction")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("construction"));

		return "modules/publicity/Construction";
	}

	@RequestMapping("/publicity/construction/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		ProjectBuilderLicence display = new ProjectBuilderLicence();

		PubConfig config = configService.getByKey("total_money");
		if(config == null){
			display.setTotalMoney(new BigDecimal(5000l));
		}else {
			display.setTotalMoney(new BigDecimal(config.getCvalue()));
		}

		List<ProjectBuilderLicence> list = buildLicenseService
				.findList(display);
		DataTableBean<ProjectBuilderLicence> result = new DataTableBean<ProjectBuilderLicence>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}

	}

}