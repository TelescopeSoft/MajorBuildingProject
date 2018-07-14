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
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;
import com.qlmsoft.mbp.modules.project.service.TenderInfoService;

/**
 * 招标投标Controller
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/project/tenderInfo")
public class TenderInfoController extends BaseController {

	@Autowired
	private TenderInfoService tenderInfoService;
	
	@ModelAttribute
	public TenderInfo get(@RequestParam(required=false) String id) {
		TenderInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tenderInfoService.get(id);
		}
		if (entity == null){
			entity = new TenderInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("project:tenderInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TenderInfo tenderInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TenderInfo> page = tenderInfoService.findPage(new Page<TenderInfo>(request, response), tenderInfo); 
		model.addAttribute("page", page);
		return "modules/project/tenderInfoList";
	}

	@RequiresPermissions("project:tenderInfo:view")
	@RequestMapping(value = "form")
	public String form(TenderInfo tenderInfo, Model model) {
		model.addAttribute("tenderInfo", tenderInfo);
		return "modules/project/tenderInfoForm";
	}

	@RequiresPermissions("project:tenderInfo:edit")
	@RequestMapping(value = "save")
	public String save(TenderInfo tenderInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tenderInfo)){
			return form(tenderInfo, model);
		}
		tenderInfoService.save(tenderInfo);
		addMessage(redirectAttributes, "保存招标投标成功");
		return "redirect:"+Global.getAdminPath()+"/project/tenderInfo/?repage";
	}
	
	@RequiresPermissions("project:tenderInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TenderInfo tenderInfo, RedirectAttributes redirectAttributes) {
		tenderInfoService.delete(tenderInfo);
		addMessage(redirectAttributes, "删除招标投标成功");
		return "redirect:"+Global.getAdminPath()+"/project/tenderInfo/?repage";
	}

}