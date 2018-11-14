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
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbHjssjdService;

/**
 * 安监申报环境交底Controller
 * @author huangzhengyu
 * @version 2018-08-01
 */
@Controller
@RequestMapping(value = "${adminPath}/project/apAjsbbHjssjd")
public class ApAjsbbHjssjdController extends BaseController {

	@Autowired
	private ApAjsbbHjssjdService apAjsbbHjssjdService;
	
	@ModelAttribute
	public ApAjsbbHjssjd get(@RequestParam(required=false) String id) {
		ApAjsbbHjssjd entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = apAjsbbHjssjdService.get(id);
		}
		if (entity == null){
			entity = new ApAjsbbHjssjd();
		}
		return entity;
	}
	
	@RequiresPermissions("project:apAjsbbHjssjd:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApAjsbbHjssjd apAjsbbHjssjd, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApAjsbbHjssjd> page = apAjsbbHjssjdService.findPage(new Page<ApAjsbbHjssjd>(request, response), apAjsbbHjssjd); 
		model.addAttribute("page", page);
		return "modules/project/apAjsbbHjssjdList";
	}

	@RequiresPermissions("project:apAjsbbHjssjd:view")
	@RequestMapping(value = "form")
	public String form(ApAjsbbHjssjd apAjsbbHjssjd, Model model) {
		model.addAttribute("apAjsbbHjssjd", apAjsbbHjssjd);
		return "modules/project/apAjsbbHjssjdForm";
	}

	@RequiresPermissions("project:apAjsbbHjssjd:edit")
	@RequestMapping(value = "save")
	public String save(ApAjsbbHjssjd apAjsbbHjssjd, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, apAjsbbHjssjd)){
			return form(apAjsbbHjssjd, model);
		}
		apAjsbbHjssjdService.save(apAjsbbHjssjd);
		addMessage(redirectAttributes, "保存安监申报环境交底成功");
		return "redirect:"+Global.getAdminPath()+"/project/apAjsbbHjssjd/?repage";
	}
	
	@RequiresPermissions("project:apAjsbbHjssjd:edit")
	@RequestMapping(value = "delete")
	public String delete(ApAjsbbHjssjd apAjsbbHjssjd, RedirectAttributes redirectAttributes) {
		apAjsbbHjssjdService.delete(apAjsbbHjssjd);
		addMessage(redirectAttributes, "删除安监申报环境交底成功");
		return "redirect:"+Global.getAdminPath()+"/project/apAjsbbHjssjd/?repage";
	}

}