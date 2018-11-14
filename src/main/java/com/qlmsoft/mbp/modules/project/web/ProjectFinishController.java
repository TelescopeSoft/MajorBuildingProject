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
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;
import com.qlmsoft.mbp.modules.project.service.ProjectFinishService;

/**
 * 竣工备案Controller
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/project/projectFinish")
public class ProjectFinishController extends BaseController {

	@Autowired
	private ProjectFinishService projectFinishService;
	
	@ModelAttribute
	public ProjectFinish get(@RequestParam(required=false) String id) {
		ProjectFinish entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = projectFinishService.get(id);
		}
		if (entity == null){
			entity = new ProjectFinish();
		}
		return entity;
	}
	
	@RequiresPermissions("project:projectFinish:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectFinish projectFinish, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProjectFinish> page = projectFinishService.findPage(new Page<ProjectFinish>(request, response), projectFinish); 
		model.addAttribute("page", page);
		return "modules/project/projectFinishList";
	}

	@RequiresPermissions("project:projectFinish:view")
	@RequestMapping(value = "form")
	public String form(ProjectFinish projectFinish, Model model) {
		model.addAttribute("projectFinish", projectFinish);
		return "modules/project/projectFinishForm";
	}

	@RequiresPermissions("project:projectFinish:edit")
	@RequestMapping(value = "save")
	public String save(ProjectFinish projectFinish, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectFinish)){
			return form(projectFinish, model);
		}
		projectFinishService.save(projectFinish);
		addMessage(redirectAttributes, "保存竣工备案成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectFinish/?repage";
	}
	
	@RequiresPermissions("project:projectFinish:edit")
	@RequestMapping(value = "delete")
	public String delete(ProjectFinish projectFinish, RedirectAttributes redirectAttributes) {
		projectFinishService.delete(projectFinish);
		addMessage(redirectAttributes, "删除竣工备案成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectFinish/?repage";
	}

}