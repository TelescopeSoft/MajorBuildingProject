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
import com.qlmsoft.mbp.modules.project.entity.ApprovalProcess;
import com.qlmsoft.mbp.modules.project.service.ApprovalProcessService;

/**
 * 发改审批事项办理详细信息Controller
 * @author huangzhengyu
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/project/approvalProcess")
public class ApprovalProcessController extends BaseController {

	@Autowired
	private ApprovalProcessService approvalProcessService;
	
	@ModelAttribute
	public ApprovalProcess get(@RequestParam(required=false) String id) {
		ApprovalProcess entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = approvalProcessService.get(id);
		}
		if (entity == null){
			entity = new ApprovalProcess();
		}
		return entity;
	}
	
	@RequiresPermissions("project:approvalProcess:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApprovalProcess approvalProcess, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApprovalProcess> page = approvalProcessService.findPage(new Page<ApprovalProcess>(request, response), approvalProcess); 
		model.addAttribute("page", page);
		return "modules/project/approvalProcessList";
	}

	@RequiresPermissions("project:approvalProcess:view")
	@RequestMapping(value = "form")
	public String form(ApprovalProcess approvalProcess, Model model) {
		model.addAttribute("approvalProcess", approvalProcess);
		return "modules/project/approvalProcessForm";
	}

	@RequiresPermissions("project:approvalProcess:edit")
	@RequestMapping(value = "save")
	public String save(ApprovalProcess approvalProcess, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, approvalProcess)){
			return form(approvalProcess, model);
		}
		approvalProcessService.save(approvalProcess);
		addMessage(redirectAttributes, "保存发改审批事项办理详细信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/approvalProcess/?repage";
	}
	
	@RequiresPermissions("project:approvalProcess:edit")
	@RequestMapping(value = "delete")
	public String delete(ApprovalProcess approvalProcess, RedirectAttributes redirectAttributes) {
		approvalProcessService.delete(approvalProcess);
		addMessage(redirectAttributes, "删除发改审批事项办理详细信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/approvalProcess/?repage";
	}

}