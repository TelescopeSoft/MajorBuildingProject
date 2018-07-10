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
import com.qlmsoft.mbp.modules.cert.entity.CorpTradeType;
import com.qlmsoft.mbp.modules.cert.service.CorpTradeTypeService;

/**
 * corptradetypeController
 * @author GLQ
 * @version 2018-04-24
 */
@Controller
@RequestMapping(value = "${adminPath}/cert/corpTradeType")
public class CorpTradeTypeController extends BaseController {

	@Autowired
	private CorpTradeTypeService corpTradeTypeService;
	
	@ModelAttribute
	public CorpTradeType get(@RequestParam(required=false) String id) {
		CorpTradeType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = corpTradeTypeService.get(id);
		}
		if (entity == null){
			entity = new CorpTradeType();
		}
		return entity;
	}
	
	@RequiresPermissions("cert:corpTradeType:view")
	@RequestMapping(value = {"list", ""})
	public String list(CorpTradeType corpTradeType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CorpTradeType> page = corpTradeTypeService.findPage(new Page<CorpTradeType>(request, response), corpTradeType); 
		model.addAttribute("page", page);
		return "modules/cert/corpTradeTypeList";
	}

	@RequiresPermissions("cert:corpTradeType:view")
	@RequestMapping(value = "form")
	public String form(CorpTradeType corpTradeType, Model model) {
		model.addAttribute("corpTradeType", corpTradeType);
		return "modules/cert/corpTradeTypeForm";
	}

	@RequiresPermissions("cert:corpTradeType:edit")
	@RequestMapping(value = "save")
	public String save(CorpTradeType corpTradeType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, corpTradeType)){
			return form(corpTradeType, model);
		}
		corpTradeTypeService.save(corpTradeType);
		addMessage(redirectAttributes, "保存corptradetype成功");
		return "redirect:"+Global.getAdminPath()+"/cert/corpTradeType/?repage";
	}
	
	@RequiresPermissions("cert:corpTradeType:edit")
	@RequestMapping(value = "delete")
	public String delete(CorpTradeType corpTradeType, RedirectAttributes redirectAttributes) {
		corpTradeTypeService.delete(corpTradeType);
		addMessage(redirectAttributes, "删除corptradetype成功");
		return "redirect:"+Global.getAdminPath()+"/cert/corpTradeType/?repage";
	}

}