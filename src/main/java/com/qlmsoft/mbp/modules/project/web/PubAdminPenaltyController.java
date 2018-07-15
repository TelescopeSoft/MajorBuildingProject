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
import com.qlmsoft.mbp.modules.project.entity.PubAdminPenalty;
import com.qlmsoft.mbp.modules.project.service.PubAdminPenaltyService;

/**
 * 行政处罚Controller
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Controller
@RequestMapping(value = "${adminPath}/project/pubAdminPenalty")
public class PubAdminPenaltyController extends BaseController {

	@Autowired
	private PubAdminPenaltyService pubAdminPenaltyService;
	
	@ModelAttribute
	public PubAdminPenalty get(@RequestParam(required=false) String id) {
		PubAdminPenalty entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubAdminPenaltyService.get(id);
		}
		if (entity == null){
			entity = new PubAdminPenalty();
		}
		return entity;
	}
	
	@RequiresPermissions("project:pubAdminPenalty:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubAdminPenalty pubAdminPenalty, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubAdminPenalty> page = pubAdminPenaltyService.findPage(new Page<PubAdminPenalty>(request, response), pubAdminPenalty); 
		model.addAttribute("page", page);
		return "modules/project/pubAdminPenaltyList";
	}

	@RequiresPermissions("project:pubAdminPenalty:view")
	@RequestMapping(value = "form")
	public String form(PubAdminPenalty pubAdminPenalty, Model model) {
		model.addAttribute("pubAdminPenalty", pubAdminPenalty);
		return "modules/project/pubAdminPenaltyForm";
	}

	@RequiresPermissions("project:pubAdminPenalty:edit")
	@RequestMapping(value = "save")
	public String save(PubAdminPenalty pubAdminPenalty, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubAdminPenalty)){
			return form(pubAdminPenalty, model);
		}
		pubAdminPenaltyService.save(pubAdminPenalty);
		addMessage(redirectAttributes, "保存行政处罚成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubAdminPenalty/?repage";
	}
	
	@RequiresPermissions("project:pubAdminPenalty:edit")
	@RequestMapping(value = "delete")
	public String delete(PubAdminPenalty pubAdminPenalty, RedirectAttributes redirectAttributes) {
		pubAdminPenaltyService.delete(pubAdminPenalty);
		addMessage(redirectAttributes, "删除行政处罚成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubAdminPenalty/?repage";
	}

}