/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
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
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;

/**
 * 发改申报项目基本信息Controller
 * @author huangzhengyu
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/project/applyProjectInfo")
public class ApplyProjectInfoController extends BaseController {

	@Autowired
	private ApplyProjectInfoService applyProjectInfoService;
	
	@ModelAttribute
	public ApplyProjectInfo get(@RequestParam(required=false) String id) {
		ApplyProjectInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = applyProjectInfoService.get(id);
		}
		if (entity == null){
			entity = new ApplyProjectInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("project:applyProjectInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApplyProjectInfo applyProjectInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApplyProjectInfo> page = applyProjectInfoService.findPage(new Page<ApplyProjectInfo>(request, response), applyProjectInfo); 
		model.addAttribute("page", page);
		return "modules/project/applyProjectInfoList";
	}

	@RequiresPermissions("project:applyProjectInfo:view")
	@RequestMapping(value = "form")
	public String form(ApplyProjectInfo applyProjectInfo, Model model) {
		model.addAttribute("applyProjectInfo", applyProjectInfo);
		return "modules/project/applyProjectInfoForm";
	}

	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "save")
	public String save(ApplyProjectInfo applyProjectInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, applyProjectInfo)){
			return form(applyProjectInfo, model);
		}
		applyProjectInfoService.save(applyProjectInfo);
		addMessage(redirectAttributes, "保存发改申报项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}
	
	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ApplyProjectInfo applyProjectInfo, RedirectAttributes redirectAttributes) {
		applyProjectInfoService.delete(applyProjectInfo);
		addMessage(redirectAttributes, "删除发改申报项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}

}