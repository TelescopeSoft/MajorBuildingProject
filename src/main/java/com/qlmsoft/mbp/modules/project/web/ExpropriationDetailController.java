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
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetail;
import com.qlmsoft.mbp.modules.project.service.ExpropriationDetailService;

/**
 * 征地信息Controller
 * @author huangzhengyu
 * @version 2018-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/project/expropriationDetail")
public class ExpropriationDetailController extends BaseController {

	@Autowired
	private ExpropriationDetailService expropriationDetailService;
	
	@ModelAttribute
	public ExpropriationDetail get(@RequestParam(required=false) String id) {
		ExpropriationDetail entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = expropriationDetailService.get(id);
		}
		if (entity == null){
			entity = new ExpropriationDetail();
		}
		return entity;
	}
	
	@RequiresPermissions("project:expropriationDetail:view")
	@RequestMapping(value = {"list", ""})
	public String list(ExpropriationDetail expropriationDetail, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ExpropriationDetail> page = expropriationDetailService.findPage(new Page<ExpropriationDetail>(request, response), expropriationDetail); 
		model.addAttribute("page", page);
		return "modules/project/expropriationDetailList";
	}

	@RequiresPermissions("project:expropriationDetail:view")
	@RequestMapping(value = "form")
	public String form(ExpropriationDetail expropriationDetail, Model model) {
		model.addAttribute("expropriationDetail", expropriationDetail);
		return "modules/project/expropriationDetailForm";
	}

	@RequiresPermissions("project:expropriationDetail:edit")
	@RequestMapping(value = "save")
	public String save(ExpropriationDetail expropriationDetail, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, expropriationDetail)){
			return form(expropriationDetail, model);
		}
		expropriationDetailService.save(expropriationDetail);
		addMessage(redirectAttributes, "保存征地信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/expropriationDetail/?repage";
	}
	
	@RequiresPermissions("project:expropriationDetail:edit")
	@RequestMapping(value = "delete")
	public String delete(ExpropriationDetail expropriationDetail, RedirectAttributes redirectAttributes) {
		expropriationDetailService.delete(expropriationDetail);
		addMessage(redirectAttributes, "删除征地信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/expropriationDetail/?repage";
	}

}