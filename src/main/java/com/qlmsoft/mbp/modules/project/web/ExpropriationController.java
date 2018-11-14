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
import com.qlmsoft.mbp.modules.project.entity.Expropriation;
import com.qlmsoft.mbp.modules.project.service.ExpropriationService;

/**
 * 征地信息Controller
 * @author huangzhengyu
 * @version 2018-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/project/expropriation")
public class ExpropriationController extends BaseController {

	@Autowired
	private ExpropriationService expropriationService;
	
	@ModelAttribute
	public Expropriation get(@RequestParam(required=false) String id) {
		Expropriation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = expropriationService.get(id);
		}
		if (entity == null){
			entity = new Expropriation();
		}
		return entity;
	}
	
	@RequiresPermissions("project:expropriation:view")
	@RequestMapping(value = {"list", ""})
	public String list(Expropriation expropriation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Expropriation> page = expropriationService.findPage(new Page<Expropriation>(request, response), expropriation); 
		model.addAttribute("page", page);
		return "modules/project/expropriationList";
	}

	@RequiresPermissions("project:expropriation:view")
	@RequestMapping(value = "form")
	public String form(Expropriation expropriation, Model model) {
		model.addAttribute("expropriation", expropriation);
		return "modules/project/expropriationForm";
	}

	@RequiresPermissions("project:expropriation:edit")
	@RequestMapping(value = "save")
	public String save(Expropriation expropriation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, expropriation)){
			return form(expropriation, model);
		}
		expropriationService.save(expropriation);
		addMessage(redirectAttributes, "保存征地信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/expropriation/?repage";
	}
	
	@RequiresPermissions("project:expropriation:edit")
	@RequestMapping(value = "delete")
	public String delete(Expropriation expropriation, RedirectAttributes redirectAttributes) {
		expropriationService.delete(expropriation);
		addMessage(redirectAttributes, "删除征地信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/expropriation/?repage";
	}

}