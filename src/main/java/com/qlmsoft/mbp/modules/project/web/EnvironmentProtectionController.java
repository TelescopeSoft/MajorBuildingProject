/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;
import com.qlmsoft.mbp.modules.project.service.PubConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlmsoft.mbp.common.config.Global;
import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.entity.EnvironmentProtection;
import com.qlmsoft.mbp.modules.project.service.EnvironmentProtectionService;

/**
 * 施工期环境保护措施Controller
 * @author huang.zhengyu
 * @version 2018-08-20
 */
@Controller
@RequestMapping(value = "${adminPath}/project/environmentProtection")
public class EnvironmentProtectionController extends BaseController {

	@Autowired
	private EnvironmentProtectionService environmentProtectionService;
	@Autowired
	PubConfigService configService;
	@Autowired
	private ApplyProjectInfoService service;
	
	@ModelAttribute
	public EnvironmentProtection get(@RequestParam(required=false) String prjCode) {
		logger.info("--------get-------" + prjCode);
		EnvironmentProtection entity = null;
		if (StringUtils.isNotBlank(prjCode)){
			entity = environmentProtectionService.getByPrjCode(prjCode);
		}
		if(entity == null){
			logger.info("--------null-------" + prjCode);
			entity = new EnvironmentProtection();
			entity.setPrjCode(prjCode);
			entity.setProjectCode(prjCode);
		}else  if (StringUtils.isNotBlank(entity.getId())){
			logger.info("--------null-------" + prjCode);
//			entity = new EnvironmentProtection();
			entity.setPrjCode(prjCode);
			entity.setProjectCode(prjCode);
		}
		return entity;
	}
	
	@RequiresPermissions("project:environmentProtection:view")
	@RequestMapping(value = {"list", ""})
	public String list(EnvironmentProtection environmentProtection, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<EnvironmentProtection> page = environmentProtectionService.findPage(new Page<EnvironmentProtection>(request, response), environmentProtection);
		model.addAttribute("page", page);
		return "modules/project/environmentProtectionList";
	}

	@RequiresPermissions("project:environmentProtection:view")
	@RequestMapping(value = "form")
	public String form(EnvironmentProtection environmentProtection, Model model) {

//		String prjCode = request.getParameter("prjCode");
//		logger.info("prjCode in request: " + prjCode);

		logger.info("prjCode in bean: " + environmentProtection.getPrjCode());

		if(environmentProtection.getCloseFlag() == null){
			environmentProtection.setCloseFlag(0);
		}
		if(environmentProtection.getWashFlag() == null){
			environmentProtection.setWashFlag(0);
		}
		model.addAttribute("environmentProtection", environmentProtection);

//		PubConfig config = configService.getByKey("total_money");
//		ApplyProjectInfo projectInfo = new ApplyProjectInfo();
//		if(config == null){
//			projectInfo.setTotalMoney(new BigDecimal(5000l));
//		}else {
//			projectInfo.setTotalMoney(new BigDecimal(config.getCvalue()));
//		}
//
//		List<ApplyProjectInfo> list = service.findList(projectInfo);
		ApplyProjectInfo project = service.getByProjectCode(environmentProtection.getPrjCode());


//		model.addAttribute("projectList", list);
		model.addAttribute("project", project);

		return "modules/project/environmentProtectionForm";
	}

	@RequiresPermissions("project:environmentProtection:edit")
	@RequestMapping(value = "save")
	public String save(EnvironmentProtection environmentProtection, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, environmentProtection)){
			return form(environmentProtection, model);
		}
		environmentProtectionService.save(environmentProtection);
		addMessage(redirectAttributes, "保存施工期环境保护措施成功");
		return "redirect:"+Global.getAdminPath()+"/project/environmentProtection/?repage";
	}
	
	@RequiresPermissions("project:environmentProtection:edit")
	@RequestMapping(value = "delete")
	public String delete(EnvironmentProtection environmentProtection, RedirectAttributes redirectAttributes) {
		environmentProtectionService.delete(environmentProtection);
		addMessage(redirectAttributes, "删除施工期环境保护措施成功");
		return "redirect:"+Global.getAdminPath()+"/project/environmentProtection/?repage";
	}

}