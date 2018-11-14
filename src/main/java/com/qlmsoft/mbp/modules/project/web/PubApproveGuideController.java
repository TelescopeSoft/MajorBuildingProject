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
import com.qlmsoft.mbp.modules.project.entity.PubApproveGuide;
import com.qlmsoft.mbp.modules.project.service.PubApproveGuideService;

/**
 * 办事指南Controller
 * @author huangzhengyu
 * @version 2018-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/project/pubApproveGuide")
public class PubApproveGuideController extends BaseController {

	@Autowired
	private PubApproveGuideService pubApproveGuideService;
	
	@ModelAttribute
	public PubApproveGuide get(@RequestParam(required=false) String id) {
		PubApproveGuide entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubApproveGuideService.get(id);
		}
		if (entity == null){
			entity = new PubApproveGuide();
		}
		return entity;
	}
	
	@RequiresPermissions("project:pubApproveGuide:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubApproveGuide pubApproveGuide, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubApproveGuide> page = pubApproveGuideService.findPage(new Page<PubApproveGuide>(request, response), pubApproveGuide); 
		model.addAttribute("page", page);
		return "modules/project/pubApproveGuideList";
	}

	@RequiresPermissions("project:pubApproveGuide:view")
	@RequestMapping(value = "form")
	public String form(PubApproveGuide pubApproveGuide, Model model) {
		model.addAttribute("pubApproveGuide", pubApproveGuide);
		return "modules/project/pubApproveGuideForm";
	}

	@RequiresPermissions("project:pubApproveGuide:edit")
	@RequestMapping(value = "save")
	public String save(PubApproveGuide pubApproveGuide, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubApproveGuide)){
			return form(pubApproveGuide, model);
		}
		pubApproveGuideService.save(pubApproveGuide);
		addMessage(redirectAttributes, "保存办事指南成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubApproveGuide/?repage";
	}
	
	@RequiresPermissions("project:pubApproveGuide:edit")
	@RequestMapping(value = "delete")
	public String delete(PubApproveGuide pubApproveGuide, RedirectAttributes redirectAttributes) {
		pubApproveGuideService.delete(pubApproveGuide);
		addMessage(redirectAttributes, "删除办事指南成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubApproveGuide/?repage";
	}

}