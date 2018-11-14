/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.util.Calendar;

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
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.service.TBProjectInfoService;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;

/**
 * 项目表Controller
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "${adminPath}/project/projectInfo")
public class TBProjectInfoController extends BaseController {

	@Autowired
	private TBProjectInfoService tBProjectInfoService;
	
	@ModelAttribute
	public ProjectInfo get(@RequestParam(required=false) String pkid) {
		ProjectInfo entity = null;
		if (StringUtils.isNotBlank(pkid)){
			entity = tBProjectInfoService.get(pkid);
		}
		if (entity == null){
			entity = new ProjectInfo();
		}
		
		logger.debug("get : " + entity.toString());
		return entity;
	}
	
	@RequiresPermissions("project:projectInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectInfo projectInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page inPage = new Page<ProjectInfo>(request, response);
		inPage.setOrderBy("CreateDate DESC");
		Page<ProjectInfo> page = tBProjectInfoService.findPage(inPage, projectInfo); 
		model.addAttribute("page", page);
//		model.addAttribute("projectInfo", projectInfo);
		return "modules/project/tBProjectInfoList";
	}

	@RequiresPermissions("project:projectInfo:view")
	@RequestMapping(value = "form")
	public String form(ProjectInfo projectInfo, Model model) {
		
		logger.debug("form : " + projectInfo.toString());
		model.addAttribute("projectInfo", projectInfo);
		return "modules/project/tBProjectInfoForm";
	}

	@RequiresPermissions("project:projectInfo:edit")
	@RequestMapping(value = "save")
	public String save(ProjectInfo projectInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectInfo)){
			return form(projectInfo, model);
		}
		tBProjectInfoService.save(projectInfo);
		addMessage(redirectAttributes, "保存项目表成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectInfo/?repage";
	}
	
	@RequiresPermissions("project:projectInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ProjectInfo projectInfo, RedirectAttributes redirectAttributes) {
		tBProjectInfoService.delete(projectInfo);
		addMessage(redirectAttributes, "删除项目表成功");
		return "redirect:"+Global.getAdminPath()+"/project/projectInfo/?repage";
	}
	
	@RequiresPermissions("project:projectInfo:edit")
	@RequestMapping(value = "toggleMajor")
	public String toggleMajor(ProjectInfo projectInfo, RedirectAttributes redirectAttributes) {
		logger.debug(projectInfo.toString());
		
		projectInfo.setXgrqsj(Calendar.getInstance().getTime());
		projectInfo.setUpdateuser(UserUtils.getUser().getName());
		
		tBProjectInfoService.toggleMajor(projectInfo);
		if("Y".equals(projectInfo.getMajorFlag())){
			addMessage(redirectAttributes, "设置成功");
		}else {
			addMessage(redirectAttributes, "取消成功");
		}
		
		return "redirect:"+Global.getAdminPath()+"/project/projectInfo/?repage";
	}

}