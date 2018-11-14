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
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import com.qlmsoft.mbp.modules.project.service.ApproveItemInfoService;

/**
 * 发改批准结果信息Controller
 * @author huangzhengyu
 * @version 2018-08-09
 */
@Controller
@RequestMapping(value = "${adminPath}/project/approveItemInfo")
public class ApproveItemInfoController extends BaseController {

	@Autowired
	private ApproveItemInfoService approveItemInfoService;
	
	@ModelAttribute
	public ApproveItemInfo get(@RequestParam(required=false) String id) {
		ApproveItemInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = approveItemInfoService.get(id);
		}
		if (entity == null){
			entity = new ApproveItemInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("project:approveItemInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApproveItemInfo approveItemInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApproveItemInfo> page = approveItemInfoService.findPage(new Page<ApproveItemInfo>(request, response), approveItemInfo); 
		model.addAttribute("page", page);
		return "modules/project/approveItemInfoList";
	}

	@RequiresPermissions("project:approveItemInfo:view")
	@RequestMapping(value = "form")
	public String form(ApproveItemInfo approveItemInfo, Model model) {
		model.addAttribute("approveItemInfo", approveItemInfo);
		return "modules/project/approveItemInfoForm";
	}

	@RequiresPermissions("project:approveItemInfo:edit")
	@RequestMapping(value = "save")
	public String save(ApproveItemInfo approveItemInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, approveItemInfo)){
			return form(approveItemInfo, model);
		}
		approveItemInfoService.save(approveItemInfo);
		addMessage(redirectAttributes, "保存发改批准结果信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/approveItemInfo/?repage";
	}
	
	@RequiresPermissions("project:approveItemInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ApproveItemInfo approveItemInfo, RedirectAttributes redirectAttributes) {
		approveItemInfoService.delete(approveItemInfo);
		addMessage(redirectAttributes, "删除发改批准结果信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/approveItemInfo/?repage";
	}

}