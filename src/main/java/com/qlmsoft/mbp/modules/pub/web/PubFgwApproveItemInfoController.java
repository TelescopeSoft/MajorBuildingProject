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
import com.qlmsoft.mbp.modules.pub.entity.PubFgwApproveItemInfo;
import com.qlmsoft.mbp.modules.pub.service.PubFgwApproveItemInfoService;

/**
 * 公示项目批准结果信息Controller
 * @author huanghzengu
 * @version 2020-11-11
 */
@Controller
@RequestMapping(value = "${adminPath}/pub/pubFgwApproveItemInfo")
public class PubFgwApproveItemInfoController extends BaseController {

	@Autowired
	private PubFgwApproveItemInfoService pubFgwApproveItemInfoService;
	
	@ModelAttribute
	public PubFgwApproveItemInfo get(@RequestParam(required=false) String id) {
		PubFgwApproveItemInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubFgwApproveItemInfoService.get(id);
		}
		if (entity == null){
			entity = new PubFgwApproveItemInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("pub:pubFgwApproveItemInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubFgwApproveItemInfo pubFgwApproveItemInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubFgwApproveItemInfo> page = pubFgwApproveItemInfoService.findPage(new Page<PubFgwApproveItemInfo>(request, response), pubFgwApproveItemInfo); 
		model.addAttribute("page", page);
		return "modules/pub/pubFgwApproveItemInfoList";
	}

	@RequiresPermissions("pub:pubFgwApproveItemInfo:view")
	@RequestMapping(value = "form")
	public String form(PubFgwApproveItemInfo pubFgwApproveItemInfo, Model model) {
		model.addAttribute("pubFgwApproveItemInfo", pubFgwApproveItemInfo);
		return "modules/pub/pubFgwApproveItemInfoForm";
	}

	@RequiresPermissions("pub:pubFgwApproveItemInfo:edit")
	@RequestMapping(value = "save")
	public String save(PubFgwApproveItemInfo pubFgwApproveItemInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubFgwApproveItemInfo)){
			return form(pubFgwApproveItemInfo, model);
		}
		pubFgwApproveItemInfoService.save(pubFgwApproveItemInfo);
		addMessage(redirectAttributes, "保存公示项目批准结果信息成功");
		return "redirect:"+Global.getAdminPath()+"/pub/pubFgwApproveItemInfo/?repage";
	}
	
	@RequiresPermissions("pub:pubFgwApproveItemInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(PubFgwApproveItemInfo pubFgwApproveItemInfo, RedirectAttributes redirectAttributes) {
		pubFgwApproveItemInfoService.delete(pubFgwApproveItemInfo);
		addMessage(redirectAttributes, "删除公示项目批准结果信息成功");
		return "redirect:"+Global.getAdminPath()+"/pub/pubFgwApproveItemInfo/?repage";
	}

}