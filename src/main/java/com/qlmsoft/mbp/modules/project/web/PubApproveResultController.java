/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.filter.AutoLoad;
import com.qlmsoft.mbp.modules.crawler.service.ApproveResultCrawler;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlmsoft.mbp.common.config.Global;
import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import com.qlmsoft.mbp.modules.project.service.PubApproveResultService;

import java.io.IOException;

/**
 * 批准结果Controller
 * @author huangzhengyu
 * @version 2018-07-13
 */
@Controller
@RequestMapping(value = "${adminPath}/project/pubApproveResult")
public class PubApproveResultController extends BaseController {

	@Autowired
	private PubApproveResultService pubApproveResultService;
	@Autowired
	private ApproveResultCrawler crawler;
	
	@ModelAttribute
	public PubApproveResult get(@RequestParam(required=false) String id) {
		PubApproveResult entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pubApproveResultService.get(id);
		}
		if (entity == null){
			entity = new PubApproveResult();
		}
		return entity;
	}
	
	@RequiresPermissions("project:pubApproveResult:view")
	@RequestMapping(value = {"list", ""})
	public String list(PubApproveResult pubApproveResult, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PubApproveResult> page = pubApproveResultService.findPage(new Page<PubApproveResult>(request, response), pubApproveResult); 
		model.addAttribute("page", page);
		return "modules/project/pubApproveResultList";
	}

	@RequiresPermissions("project:pubApproveResult:view")
	@RequestMapping(value = "form")
	public String form(PubApproveResult pubApproveResult, Model model) {
		model.addAttribute("pubApproveResult", pubApproveResult);
		return "modules/project/pubApproveResultForm";
	}

	@RequiresPermissions("project:pubApproveResult:edit")
	@RequestMapping(value = "save")
	public String save(PubApproveResult pubApproveResult, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pubApproveResult)){
			return form(pubApproveResult, model);
		}
		pubApproveResultService.save(pubApproveResult);
		addMessage(redirectAttributes, "保存批准结果成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubApproveResult/?repage";
	}
	
	@RequiresPermissions("project:pubApproveResult:edit")
	@RequestMapping(value = "delete")
	public String delete(PubApproveResult pubApproveResult, RedirectAttributes redirectAttributes) {
		pubApproveResultService.delete(pubApproveResult);
		addMessage(redirectAttributes, "删除批准结果成功");
		return "redirect:"+Global.getAdminPath()+"/project/pubApproveResult/?repage";
	}

	@RequestMapping(value = "crawl")
	@ResponseBody
	public String crawl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String prjCode = request.getParameter("prjCode");
		ApplyProjectInfo prj = new ApplyProjectInfo();
		prj.setProjectCode(prjCode);
		crawler.synchByPrjName(prj);
		return "ok";
	}

}