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
import com.qlmsoft.mbp.modules.project.entity.ContractRecord;
import com.qlmsoft.mbp.modules.project.service.ContractRecordService;

/**
 * 合同备案Controller
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/project/contractRecord")
public class ContractRecordController extends BaseController {

	@Autowired
	private ContractRecordService contractRecordService;
	
	@ModelAttribute
	public ContractRecord get(@RequestParam(required=false) String id) {
		ContractRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = contractRecordService.get(id);
		}
		if (entity == null){
			entity = new ContractRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("project:contractRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(ContractRecord contractRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ContractRecord> page = contractRecordService.findPage(new Page<ContractRecord>(request, response), contractRecord); 
		model.addAttribute("page", page);
		return "modules/project/contractRecordList";
	}

	@RequiresPermissions("project:contractRecord:view")
	@RequestMapping(value = "form")
	public String form(ContractRecord contractRecord, Model model) {
		model.addAttribute("contractRecord", contractRecord);
		return "modules/project/contractRecordForm";
	}

	@RequiresPermissions("project:contractRecord:edit")
	@RequestMapping(value = "save")
	public String save(ContractRecord contractRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, contractRecord)){
			return form(contractRecord, model);
		}
		contractRecordService.save(contractRecord);
		addMessage(redirectAttributes, "保存合同备案成功");
		return "redirect:"+Global.getAdminPath()+"/project/contractRecord/?repage";
	}
	
	@RequiresPermissions("project:contractRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(ContractRecord contractRecord, RedirectAttributes redirectAttributes) {
		contractRecordService.delete(contractRecord);
		addMessage(redirectAttributes, "删除合同备案成功");
		return "redirect:"+Global.getAdminPath()+"/project/contractRecord/?repage";
	}

}