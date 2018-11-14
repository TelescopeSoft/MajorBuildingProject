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
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbDwryService;

/**
 * 质量报监单位人员Controller
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
@RequestMapping(value = "${adminPath}/project/apZjsbbDwry")
public class ApZjsbbDwryController extends BaseController {

	@Autowired
	private ApZjsbbDwryService apZjsbbDwryService;
	
	@ModelAttribute
	public ApZjsbbDwry get(@RequestParam(required=false) String id) {
		ApZjsbbDwry entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = apZjsbbDwryService.get(id);
		}
		if (entity == null){
			entity = new ApZjsbbDwry();
		}
		return entity;
	}
	
	@RequiresPermissions("project:apZjsbbDwry:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApZjsbbDwry apZjsbbDwry, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApZjsbbDwry> page = apZjsbbDwryService.findPage(new Page<ApZjsbbDwry>(request, response), apZjsbbDwry); 
		model.addAttribute("page", page);
		return "modules/project/apZjsbbDwryList";
	}

	@RequiresPermissions("project:apZjsbbDwry:view")
	@RequestMapping(value = "form")
	public String form(ApZjsbbDwry apZjsbbDwry, Model model) {
		model.addAttribute("apZjsbbDwry", apZjsbbDwry);
		return "modules/project/apZjsbbDwryForm";
	}

	@RequiresPermissions("project:apZjsbbDwry:edit")
	@RequestMapping(value = "save")
	public String save(ApZjsbbDwry apZjsbbDwry, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, apZjsbbDwry)){
			return form(apZjsbbDwry, model);
		}
		apZjsbbDwryService.save(apZjsbbDwry);
		addMessage(redirectAttributes, "保存质量报监单位人员成功");
		return "redirect:"+Global.getAdminPath()+"/project/apZjsbbDwry/?repage";
	}
	
	@RequiresPermissions("project:apZjsbbDwry:edit")
	@RequestMapping(value = "delete")
	public String delete(ApZjsbbDwry apZjsbbDwry, RedirectAttributes redirectAttributes) {
		apZjsbbDwryService.delete(apZjsbbDwry);
		addMessage(redirectAttributes, "删除质量报监单位人员成功");
		return "redirect:"+Global.getAdminPath()+"/project/apZjsbbDwry/?repage";
	}

}