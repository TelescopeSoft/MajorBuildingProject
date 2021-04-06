/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.pub.web;

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
import com.qlmsoft.mbp.modules.pub.entity.PubFgwProjectInfo;
import com.qlmsoft.mbp.modules.pub.service.PubFgwProjectInfoService;

/**
 * 重大建设项目基本信息Controller
 * @author huangzhengyu
 * @version 2020-11-11
 */
@Controller
@RequestMapping(value = "${adminPath}/pub/pubFgwProjectInfo")
public class PubFgwProjectInfoController extends BaseController {

	@Autowired
	private PubFgwProjectInfoService pubFgwProjectInfoService;
	
	@ModelAttribute
	public PubFgwProjectInfo get(@RequestParam(required=false) String id) {
		PubFgwProjectInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubFgwProjectInfoService.get(id);
		}
		if (entity == null){
			entity = new PubFgwProjectInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("pub:pubFgwProjectInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubFgwProjectInfo pubFgwProjectInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubFgwProjectInfo> page = pubFgwProjectInfoService.findPage(new Page<PubFgwProjectInfo>(request, response), pubFgwProjectInfo); 
		model.addAttribute("page", page);
		return "modules/pub/pubFgwProjectInfoList";
	}

	@RequiresPermissions("pub:pubFgwProjectInfo:view")
	@RequestMapping(value = "form")
	public String form(PubFgwProjectInfo pubFgwProjectInfo, Model model) {
		model.addAttribute("pubFgwProjectInfo", pubFgwProjectInfo);
		return "modules/pub/pubFgwProjectInfoForm";
	}

	@RequiresPermissions("pub:pubFgwProjectInfo:edit")
	@RequestMapping(value = "save")
	public String save(PubFgwProjectInfo pubFgwProjectInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubFgwProjectInfo)){
			return form(pubFgwProjectInfo, model);
		}
		pubFgwProjectInfoService.save(pubFgwProjectInfo);
		addMessage(redirectAttributes, "保存重大建设项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/pub/pubFgwProjectInfo/?repage";
	}
	
	@RequiresPermissions("pub:pubFgwProjectInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(PubFgwProjectInfo pubFgwProjectInfo, RedirectAttributes redirectAttributes) {
		pubFgwProjectInfoService.delete(pubFgwProjectInfo);
		addMessage(redirectAttributes, "删除重大建设项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/pub/pubFgwProjectInfo/?repage";
	}

}