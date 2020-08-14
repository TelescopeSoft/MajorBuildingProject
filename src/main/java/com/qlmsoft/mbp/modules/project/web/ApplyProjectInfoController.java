/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.common.utils.excel.ExportExcel;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;
import org.apache.poi.ss.usermodel.Row;
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
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * 发改申报项目基本信息Controller
 * @author huangzhengyu
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/project/applyProjectInfo")
public class ApplyProjectInfoController extends BaseController {

	@Autowired
	private ApplyProjectInfoService applyProjectInfoService;

	@ModelAttribute
	public ApplyProjectInfo get(@RequestParam(required=false) String id) {
		ApplyProjectInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = applyProjectInfoService.get(id);
		}
		if (entity == null){
			entity = new ApplyProjectInfo();
		}
		return entity;
	}

	@RequiresPermissions("project:applyProjectInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApplyProjectInfo applyProjectInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ApplyProjectInfo> page = applyProjectInfoService.findPage(new Page<ApplyProjectInfo>(request, response), applyProjectInfo);
		model.addAttribute("page", page);
		return "modules/project/applyProjectInfoList";
	}

	@RequiresPermissions("project:applyProjectInfo:view")
	@RequestMapping(value = "form")
	public String form(ApplyProjectInfo applyProjectInfo, Model model) {
		model.addAttribute("applyProjectInfo", applyProjectInfo);
		return "modules/project/applyProjectInfoForm";
	}

	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "save")
	public String save(ApplyProjectInfo applyProjectInfo, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, applyProjectInfo)){
//			return form(applyProjectInfo, model);
//		}
		applyProjectInfoService.save(applyProjectInfo);
		addMessage(redirectAttributes, "保存发改申报项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}

	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ApplyProjectInfo applyProjectInfo, RedirectAttributes redirectAttributes) {
		applyProjectInfoService.delete(applyProjectInfo);
		addMessage(redirectAttributes, "删除发改申报项目基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}

	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "toggleMajor")
	public String toggleMajor(ApplyProjectInfo applyProjectInfo, RedirectAttributes redirectAttributes) {
		logger.debug(applyProjectInfo.toString());


		applyProjectInfoService.toggleMajor(applyProjectInfo);
		if("Y".equals(applyProjectInfo.getMajorFlag())){
			addMessage(redirectAttributes, "设置成功");
		}else {
			addMessage(redirectAttributes, "取消成功");
		}

		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}

	@RequiresPermissions("project:applyProjectInfo:edit")
	@RequestMapping(value = "toggleDisplay")
	public String toggleDisplay(ApplyProjectInfo applyProjectInfo, RedirectAttributes redirectAttributes) {
		logger.debug(applyProjectInfo.toString());

		applyProjectInfoService.toggleDisplay(applyProjectInfo);
		if("Y".equals(applyProjectInfo.getDisplayFlag())){
			addMessage(redirectAttributes, "设置成功");
		}else {
			addMessage(redirectAttributes, "取消成功");
		}

		return "redirect:"+Global.getAdminPath()+"/project/applyProjectInfo/?repage";
	}

	@RequiresPermissions("project:applyProjectInfo:view")
	@RequestMapping(value = "export")
	public void export(ApplyProjectInfo bean, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Page<ApplyProjectInfo> pageIn = new Page<ApplyProjectInfo>(req, resp);
		pageIn.setPageSize(99999);
		Page<ApplyProjectInfo> page = applyProjectInfoService.findPage(pageIn, bean);

		List<ApplyProjectInfo> list = page.getList();

		String fileName = "项目列表_" + DateUtils.getDate() + ".xlsx";


		List<String> headerList = Lists.newArrayList();
		headerList.add("项目代码");
		headerList.add("项目名称");
		headerList.add("拟开工时间");
		headerList.add("拟建成时间");
		headerList.add("总投资额（万元）");
		headerList.add("建设地点");
		headerList.add("申报时间");

		headerList.add("项目类型");
		headerList.add("建设性质");
		headerList.add("核准目录分类");
		headerList.add("项目（法人）单位");
		headerList.add("项目法人证照号码");
		headerList.add("建设规模及内容");

		headerList.add("用地面积（公顷）");
		headerList.add("新增用地面积（公顷）");
		headerList.add("农用地面积（公顷）");
		headerList.add("项目资本金（万元）");
		headerList.add("资金来源");
		//headerList.add("财政资金来源");

		ExportExcel ee = new ExportExcel("项目列表", headerList);

		for (ApplyProjectInfo i : list) {
			Row row = ee.addRow();
			ee.addCell(row, 0, i.getProjectCode());
			ee.addCell(row, 1, i.getProjectName());
			ee.addCell(row, 2, i.getStartYear());
			ee.addCell(row, 3, i.getEndYear());
			ee.addCell(row, 4, i.getTotalMoney().toString());
			ee.addCell(row, 5, i.getAddressDetail());
			ee.addCell(row, 6, DateUtils.formatDate(i.getApplyDate(), "yyyy-MM-dd") );
			ee.addCell(row, 7, i.getProjectTypeLabel());
			ee.addCell(row, 8, i.getProjectNatureLabel());
			ee.addCell(row, 9, i.getCatalogName());
			ee.addCell(row, 10, i.getEnterpriseName());
			ee.addCell(row, 11, i.getLerepCertNo());
			ee.addCell(row, 12, i.getScaleContent());
			ee.addCell(row, 13, i.getYdmj());
			ee.addCell(row, 14, i.getXzydmj());
			ee.addCell(row, 15, i.getNydmj());
			ee.addCell(row, 16, i.getXmzbj());
			ee.addCell(row, 17, i.getZjly());
		}

		try {
			ee.write(resp, fileName);
			return;
		} catch (FileNotFoundException e) {
			req.setAttribute("exception", new FileNotFoundException(
					"请求的文件不存在"));
			req.getRequestDispatcher("/WEB-INF/views/error/404.jsp")
					.forward(req, resp);
		} finally {
			ee.dispose();
		}
	}

}
