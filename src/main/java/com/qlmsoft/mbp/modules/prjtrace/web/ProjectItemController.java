/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectStatus;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectType;
import com.qlmsoft.mbp.modules.prjtrace.service.ProjectStatusService;
import com.qlmsoft.mbp.modules.prjtrace.service.ProjectTypeService;
import com.qlmsoft.mbp.modules.sys.entity.Office;
import org.apache.axis2.databinding.types.soapencoding.Integer;
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
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectItem;
import com.qlmsoft.mbp.modules.prjtrace.service.ProjectItemService;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 跟踪项目表Controller
 *
 * @author aaron
 * @version 2018-12-27
 */
@Controller
@RequestMapping(value = "${adminPath}/prjtrace/projectItem")
public class ProjectItemController extends BaseController {

    @Autowired
    private ProjectItemService projectItemService;
    @Autowired
    private ProjectStatusService projectStatusService;
    @Autowired
    private ProjectTypeService projectTypeService;

    @ModelAttribute
    public ProjectItem get(@RequestParam(required = false) String id) {
        ProjectItem entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = projectItemService.get(id);
        }
        if (entity == null) {
            entity = new ProjectItem();
        }
        return entity;
    }

    @RequiresPermissions("prjtrace:projectItem:view")
    @RequestMapping(value = {"list", ""})
    public String list(ProjectItem projectItem, HttpServletRequest request, HttpServletResponse response, Model model) {
//        Page<ProjectItem> page = projectItemService.findPage(new Page<ProjectItem>(request, response), projectItem);
        List<ProjectItem> list = projectItemService.findList(projectItem);
        model.addAttribute("list", list);
        return "modules/prjtrace/projectItemList";
    }

    @RequiresPermissions("prjtrace:projectItem:view")
    @RequestMapping(value = "form")
    public String form(ProjectItem projectItem, Model model) {

        if(projectItem.getParent() != null && StringUtils.isNotEmpty(projectItem.getParent().getId())){
            projectItem.setParent(projectItemService.get(projectItem.getParent().getId()));
            if(projectItem.getParent() != null && projectItem.getParent().getPrjType() != null){
                projectItem.setPrjType(projectItem.getParent().getPrjType());
            }
        }

        projectItem.setOfyear(DateUtils.getYear());
        model.addAttribute("projectItem", projectItem);

        ProjectType projectType = new ProjectType();
        List<ProjectType> prjTypeList = projectTypeService.findList(projectType);
        model.addAttribute("prjTypeList", prjTypeList);

        ProjectStatus prjStatus = new ProjectStatus();
        prjStatus.setYear(projectItem.getOfyear());
        List<ProjectStatus> prjStatusList = projectStatusService.findList(prjStatus);
        model.addAttribute("prjStatusList", prjStatusList);

        return "modules/prjtrace/projectItemForm";
    }

    @RequiresPermissions("prjtrace:projectItem:edit")
    @RequestMapping(value = "save")
    public String save(ProjectItem projectItem, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, projectItem)) {
            return form(projectItem, model);
        }
        projectItemService.save(projectItem);
        addMessage(redirectAttributes, "保存跟踪项目成功");
        return "redirect:" + Global.getAdminPath() + "/prjtrace/projectItem/?repage";
    }

    @RequiresPermissions("prjtrace:projectItem:edit")
    @RequestMapping(value = "delete")
    public String delete(ProjectItem projectItem, RedirectAttributes redirectAttributes) {
        projectItemService.delete(projectItem);
        addMessage(redirectAttributes, "删除跟踪项目成功");
        return "redirect:" + Global.getAdminPath() + "/prjtrace/projectItem/?repage";
    }

    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) Integer level, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        ProjectItem projectItem = new ProjectItem();
        if (level == null) {
            projectItem.setLevel(ProjectItem.LEVEL_ROOT);
        }

        List<ProjectItem> list = projectItemService.findList(projectItem);
        for (int i = 0; i < list.size(); i++) {
            ProjectItem e = list.get(i);
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", e.getId());
            map.put("pId", e.getParent() == null ? "0" : e.getParent().getId());
            map.put("pIds", e.getParentIds());
            map.put("name", e.getName());

            mapList.add(map);
        }
        return mapList;
    }

}