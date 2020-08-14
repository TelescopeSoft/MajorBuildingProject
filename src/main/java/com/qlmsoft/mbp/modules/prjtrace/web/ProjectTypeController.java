/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.web;

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
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectType;
import com.qlmsoft.mbp.modules.prjtrace.service.ProjectTypeService;

/**
 * 项目类型Controller
 * @author aaron
 * @version 2018-12-27
 */
@Controller
@RequestMapping(value = "${adminPath}/prjtrace/projectType")
public class ProjectTypeController extends BaseController {

	@Autowired
	private ProjectTypeService projectTypeService;
	
	@ModelAttribute
	public ProjectType get(@RequestParam(required=false) String id) {
		ProjectType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = projectTypeService.get(id);
		}
		if (entity == null){
			entity = new ProjectType();
		}
		return entity;
	}
	
	@RequiresPermissions("prjtrace:projectType:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectType projectType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProjectType> page = projectTypeService.findPage(new Page<ProjectType>(request, response), projectType); 
		model.addAttribute("page", page);
		return "modules/prjtrace/projectTypeList";
	}

	@RequiresPermissions("prjtrace:projectType:view")
	@RequestMapping(value = "form")
	public String form(ProjectType projectType, Model model) {
		model.addAttribute("projectType", projectType);
		return "modules/prjtrace/projectTypeForm";
	}

	@RequiresPermissions("prjtrace:projectType:edit")
	@RequestMapping(value = "save")
	public String save(ProjectType projectType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectType)){
			return form(projectType, model);
		}
		projectTypeService.save(projectType);
		addMessage(redirectAttributes, "保存项目类型成功");
		return "redirect:"+Global.getAdminPath()+"/prjtrace/projectType/?repage";
	}
	
	@RequiresPermissions("prjtrace:projectType:edit")
	@RequestMapping(value = "delete")
	public String delete(ProjectType projectType, RedirectAttributes redirectAttributes) {
		projectTypeService.delete(projectType);
		addMessage(redirectAttributes, "删除项目类型成功");
		return "redirect:"+Global.getAdminPath()+"/prjtrace/projectType/?repage";
	}

}