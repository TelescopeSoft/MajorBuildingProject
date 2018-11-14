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
import com.qlmsoft.mbp.modules.project.entity.CodeInfo;
import com.qlmsoft.mbp.modules.project.service.CodeInfoService;

/**
 * 项目代码表Controller
 * @author huang.zhengyu
 * @version 2018-08-29
 */
@Controller
@RequestMapping(value = "${adminPath}/project/codeInfo")
public class CodeInfoController extends BaseController {

	@Autowired
	private CodeInfoService codeInfoService;
	
	@ModelAttribute
	public CodeInfo get(@RequestParam(required=false) String id) {
		CodeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = codeInfoService.get(id);
		}
		if (entity == null){
			entity = new CodeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("project:codeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(CodeInfo codeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CodeInfo> page = codeInfoService.findPage(new Page<CodeInfo>(request, response), codeInfo); 
		model.addAttribute("page", page);
		return "modules/project/codeInfoList";
	}

	@RequiresPermissions("project:codeInfo:view")
	@RequestMapping(value = "form")
	public String form(CodeInfo codeInfo, Model model) {
		model.addAttribute("codeInfo", codeInfo);
		return "modules/project/codeInfoForm";
	}

	@RequiresPermissions("project:codeInfo:edit")
	@RequestMapping(value = "save")
	public String save(CodeInfo codeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, codeInfo)){
			return form(codeInfo, model);
		}
		codeInfoService.save(codeInfo);
		addMessage(redirectAttributes, "保存项目代码表成功");
		return "redirect:"+Global.getAdminPath()+"/project/codeInfo/?repage";
	}
	
	@RequiresPermissions("project:codeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(CodeInfo codeInfo, RedirectAttributes redirectAttributes) {
		codeInfoService.delete(codeInfo);
		addMessage(redirectAttributes, "删除项目代码表成功");
		return "redirect:"+Global.getAdminPath()+"/project/codeInfo/?repage";
	}

}