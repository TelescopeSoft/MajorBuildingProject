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
import com.qlmsoft.mbp.modules.project.entity.PubConfig;
import com.qlmsoft.mbp.modules.project.service.PubConfigService;

/**
 * 配置表Controller
 * @author huangzhengyu
 * @version 2018-08-16
 */
@Controller
@RequestMapping(value = "${adminPath}/project/pubConfig")
public class PubConfigController extends BaseController {

	@Autowired
	private PubConfigService pubConfigService;
	
	@ModelAttribute
	public PubConfig get(@RequestParam(required=false) String id) {
		PubConfig entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubConfigService.get(id);
		}
		if (entity == null){
			entity = new PubConfig();
		}
		return entity;
	}
	
	@RequiresPermissions("project:pubConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubConfig pubConfig, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubConfig> page = pubConfigService.findPage(new Page<PubConfig>(request, response), pubConfig); 
		model.addAttribute("page", page);
		return "modules/project/pubConfigList";
	}

	@RequiresPermissions("project:pubConfig:view")
	@RequestMapping(value = "form")
	public String form(PubConfig pubConfig, Model model) {
		model.addAttribute("pubConfig", pubConfig);
		return "modules/project/pubConfigForm";
	}

	@RequiresPermissions("project:pubConfig:edit")
	@RequestMapping(value = "save")
	public String save(PubConfig pubConfig, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubConfig)){
			return form(pubConfig, model);
		}
		pubConfigService.save(pubConfig);
		addMessage(redirectAttributes, "保存配置表成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubConfig/?repage";
	}
	
	@RequiresPermissions("project:pubConfig:edit")
	@RequestMapping(value = "delete")
	public String delete(PubConfig pubConfig, RedirectAttributes redirectAttributes) {
		pubConfigService.delete(pubConfig);
		addMessage(redirectAttributes, "删除配置表成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubConfig/?repage";
	}

}