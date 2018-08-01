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
import com.qlmsoft.mbp.modules.project.entity.Trade;
import com.qlmsoft.mbp.modules.project.service.TradeService;

/**
 * 招标投标Controller
 * @author huangzhengyu
 * @version 2018-07-31
 */
@Controller
@RequestMapping(value = "${adminPath}/project/trade")
public class TradeController extends BaseController {

	@Autowired
	private TradeService tradeService;
	
	@ModelAttribute
	public Trade get(@RequestParam(required=false) String id) {
		Trade entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tradeService.get(id);
		}
		if (entity == null){
			entity = new Trade();
		}
		return entity;
	}
	
	@RequiresPermissions("project:trade:view")
	@RequestMapping(value = {"list", ""})
	public String list(Trade trade, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Trade> page = tradeService.findPage(new Page<Trade>(request, response), trade); 
		model.addAttribute("page", page);
		return "modules/project/tradeList";
	}

	@RequiresPermissions("project:trade:view")
	@RequestMapping(value = "form")
	public String form(Trade trade, Model model) {
		model.addAttribute("trade", trade);
		return "modules/project/tradeForm";
	}

	@RequiresPermissions("project:trade:edit")
	@RequestMapping(value = "save")
	public String save(Trade trade, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, trade)){
			return form(trade, model);
		}
		tradeService.save(trade);
		addMessage(redirectAttributes, "保存招标投标成功");
		return "redirect:"+Global.getAdminPath()+"/project/trade/?repage";
	}
	
	@RequiresPermissions("project:trade:edit")
	@RequestMapping(value = "delete")
	public String delete(Trade trade, RedirectAttributes redirectAttributes) {
		tradeService.delete(trade);
		addMessage(redirectAttributes, "删除招标投标成功");
		return "redirect:"+Global.getAdminPath()+"/project/trade/?repage";
	}

}