/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;
import com.qlmsoft.mbp.modules.project.service.ProjectBuilderLicenceService;

/**
 * 施工许可信息Controller
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
@RequestMapping(value = "${adminPath}/project/projectBuilderLicence")
public class ProjectBuilderLicenceController extends BaseController {

	@Autowired
	private ProjectBuilderLicenceService projectBuilderLicenceService;
	
	@ModelAttribute
	public ProjectBuilderLicence get(@RequestParam(required=false) String id) {
		ProjectBuilderLicence entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = projectBuilderLicenceService.get(id);
		}
		if (entity == null){
			entity = new ProjectBuilderLicence();
		}
		return entity;
	}
	
	@RequiresPermissions("project:projectBuilderLicence:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectBuilderLicence projectBuilderLicence, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProjectBuilderLicence> page = projectBuilderLicenceService.findPage(new Page<ProjectBuilderLicence>(request, response), projectBuilderLicence); 
		model.addAttribute("page", page);
		return "modules/project/projectBuilderLicenceList";
	}

	@RequiresPermissions("project:projectBuilderLicence:view")
	@RequestMapping(value = "form")
	public String form(ProjectBuilderLicence projectBuilderLicence, Model model) {
		model.addAttribute("projectBuilderLicence", projectBuilderLicence);
		return "modules/project/projectBuilderLicenceForm";
	}

	@RequiresPermissions("project:projectBuilderLicence:edit")
	@RequestMapping(value = "save")
	public String save(ProjectBuilderLicence projectBuilderLicence, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectBuilderLicence)){
			return form(projectBuilderLicence, model);
		}
		projectBuilderLicenceService.save(projectBuilderLicence);
		addMessage(redirectAttributes, "保存施工许可信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectBuilderLicence/?repage";
	}
	
	@RequiresPermissions("project:projectBuilderLicence:edit")
	@RequestMapping(value = "delete")
	public String delete(ProjectBuilderLicence projectBuilderLicence, RedirectAttributes redirectAttributes) {
		projectBuilderLicenceService.delete(projectBuilderLicence);
		addMessage(redirectAttributes, "删除施工许可信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectBuilderLicence/?repage";
	}

}