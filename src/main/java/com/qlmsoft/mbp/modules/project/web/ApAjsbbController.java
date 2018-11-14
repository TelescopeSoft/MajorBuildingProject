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
import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbService;

/**
 * 安监申报Controller
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/project/apAjsbb")
public class ApAjsbbController extends BaseController {

	@Autowired
	private ApAjsbbService apAjsbbService;
	
	@ModelAttribute
	public ApAjsbb get(@RequestParam(required=false) String id) {
		ApAjsbb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = apAjsbbService.get(id);
		}
		if (entity == null){
			entity = new ApAjsbb();
		}
		return entity;
	}
	
	@RequiresPermissions("project:apAjsbb:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApAjsbb apAjsbb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApAjsbb> page = apAjsbbService.findPage(new Page<ApAjsbb>(request, response), apAjsbb); 
		model.addAttribute("page", page);
		return "modules/project/apAjsbbList";
	}

	@RequiresPermissions("project:apAjsbb:view")
	@RequestMapping(value = "form")
	public String form(ApAjsbb apAjsbb, Model model) {
		model.addAttribute("apAjsbb", apAjsbb);
		return "modules/project/apAjsbbForm";
	}

	@RequiresPermissions("project:apAjsbb:edit")
	@RequestMapping(value = "save")
	public String save(ApAjsbb apAjsbb, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, apAjsbb)){
			return form(apAjsbb, model);
		}
		apAjsbbService.save(apAjsbb);
		addMessage(redirectAttributes, "保存安监申报成功");
		return "redirect:"+Global.getAdminPath()+"/project/apAjsbb/?repage";
	}
	
	@RequiresPermissions("project:apAjsbb:edit")
	@RequestMapping(value = "delete")
	public String delete(ApAjsbb apAjsbb, RedirectAttributes redirectAttributes) {
		apAjsbbService.delete(apAjsbb);
		addMessage(redirectAttributes, "删除安监申报成功");
		return "redirect:"+Global.getAdminPath()+"/project/apAjsbb/?repage";
	}

}