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
import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbService;

/**
 * 质监申报Controller
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/project/apZjsbb")
public class ApZjsbbController extends BaseController {

	@Autowired
	private ApZjsbbService apZjsbbService;
	
	@ModelAttribute
	public ApZjsbb get(@RequestParam(required=false) String id) {
		ApZjsbb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = apZjsbbService.get(id);
		}
		if (entity == null){
			entity = new ApZjsbb();
		}
		return entity;
	}
	
	@RequiresPermissions("project:apZjsbb:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApZjsbb apZjsbb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApZjsbb> page = apZjsbbService.findPage(new Page<ApZjsbb>(request, response), apZjsbb); 
		model.addAttribute("page", page);
		return "modules/project/apZjsbbList";
	}

	@RequiresPermissions("project:apZjsbb:view")
	@RequestMapping(value = "form")
	public String form(ApZjsbb apZjsbb, Model model) {
		model.addAttribute("apZjsbb", apZjsbb);
		return "modules/project/apZjsbbForm";
	}

	@RequiresPermissions("project:apZjsbb:edit")
	@RequestMapping(value = "save")
	public String save(ApZjsbb apZjsbb, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, apZjsbb)){
			return form(apZjsbb, model);
		}
		apZjsbbService.save(apZjsbb);
		addMessage(redirectAttributes, "保存质监申报成功");
		return "redirect:"+Global.getAdminPath()+"/project/apZjsbb/?repage";
	}
	
	@RequiresPermissions("project:apZjsbb:edit")
	@RequestMapping(value = "delete")
	public String delete(ApZjsbb apZjsbb, RedirectAttributes redirectAttributes) {
		apZjsbbService.delete(apZjsbb);
		addMessage(redirectAttributes, "删除质监申报成功");
		return "redirect:"+Global.getAdminPath()+"/project/apZjsbb/?repage";
	}

}