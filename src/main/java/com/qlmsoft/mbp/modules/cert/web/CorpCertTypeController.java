/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.cert.web;

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
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.cert.entity.CorpCertType;
import com.qlmsoft.mbp.modules.cert.service.CorpCertTypeService;

/**
 * corpcerttypeController
 * @author GLQ
 * @version 2018-04-24
 */
@Controller
@RequestMapping(value = "${adminPath}/cert/corpCertType")
public class CorpCertTypeController extends BaseController {

	@Autowired
	private CorpCertTypeService corpCertTypeService;
	
	@ModelAttribute
	public CorpCertType get(@RequestParam(required=false) String id) {
		CorpCertType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = corpCertTypeService.get(id);
		}
		if (entity == null){
			entity = new CorpCertType();
		}
		return entity;
	}
	
	@RequiresPermissions("cert:corpCertType:view")
	@RequestMapping(value = {"list", ""})
	public String list(CorpCertType corpCertType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CorpCertType> page = corpCertTypeService.findPage(new Page<CorpCertType>(request, response), corpCertType); 
		model.addAttribute("page", page);
		return "modules/cert/corpCertTypeList";
	}

	@RequiresPermissions("cert:corpCertType:view")
	@RequestMapping(value = "form")
	public String form(CorpCertType corpCertType, Model model) {
		model.addAttribute("corpCertType", corpCertType);
		return "modules/cert/corpCertTypeForm";
	}

	@RequiresPermissions("cert:corpCertType:edit")
	@RequestMapping(value = "save")
	public String save(CorpCertType corpCertType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, corpCertType)){
			return form(corpCertType, model);
		}
		corpCertTypeService.save(corpCertType);
		addMessage(redirectAttributes, "保存corpcerttype成功");
		return "redirect:"+Global.getAdminPath()+"/cert/corpCertType/?repage";
	}
	
	@RequiresPermissions("cert:corpCertType:edit")
	@RequestMapping(value = "delete")
	public String delete(CorpCertType corpCertType, RedirectAttributes redirectAttributes) {
		corpCertTypeService.delete(corpCertType);
		addMessage(redirectAttributes, "删除corpcerttype成功");
		return "redirect:"+Global.getAdminPath()+"/cert/corpCertType/?repage";
	}

}