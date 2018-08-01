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
import com.qlmsoft.mbp.modules.project.entity.PubTradeContent;
import com.qlmsoft.mbp.modules.project.service.PubTradeContentService;

/**
 * 招标投标内容Controller
 * @author aaron
 * @version 2018-07-31
 */
@Controller
@RequestMapping(value = "${adminPath}/project/pubTradeContent")
public class PubTradeContentController extends BaseController {

	@Autowired
	private PubTradeContentService pubTradeContentService;
	
	@ModelAttribute
	public PubTradeContent get(@RequestParam(required=false) String id) {
		PubTradeContent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubTradeContentService.get(id);
		}
		if (entity == null){
			entity = new PubTradeContent();
		}
		return entity;
	}
	
	@RequiresPermissions("project:pubTradeContent:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubTradeContent pubTradeContent, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubTradeContent> page = pubTradeContentService.findPage(new Page<PubTradeContent>(request, response), pubTradeContent); 
		model.addAttribute("page", page);
		return "modules/project/pubTradeContentList";
	}

	@RequiresPermissions("project:pubTradeContent:view")
	@RequestMapping(value = "form")
	public String form(PubTradeContent pubTradeContent, Model model) {
		model.addAttribute("pubTradeContent", pubTradeContent);
		return "modules/project/pubTradeContentForm";
	}

	@RequiresPermissions("project:pubTradeContent:edit")
	@RequestMapping(value = "save")
	public String save(PubTradeContent pubTradeContent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubTradeContent)){
			return form(pubTradeContent, model);
		}
		pubTradeContentService.save(pubTradeContent);
		addMessage(redirectAttributes, "保存招标投标内容成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubTradeContent/?repage";
	}
	
	@RequiresPermissions("project:pubTradeContent:edit")
	@RequestMapping(value = "delete")
	public String delete(PubTradeContent pubTradeContent, RedirectAttributes redirectAttributes) {
		pubTradeContentService.delete(pubTradeContent);
		addMessage(redirectAttributes, "删除招标投标内容成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubTradeContent/?repage";
	}

}