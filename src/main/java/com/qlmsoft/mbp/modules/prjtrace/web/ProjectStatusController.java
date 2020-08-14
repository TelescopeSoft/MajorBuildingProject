
package com.qlmsoft.mbp.modules.prjtrace.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlmsoft.mbp.common.utils.DateUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlmsoft.mbp.common.config.Global;
import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectStatus;
import com.qlmsoft.mbp.modules.prjtrace.service.ProjectStatusService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目状态Controller
 *
 * @author aaron
 * @version 2018-12-27
 */
@Controller
@RequestMapping(value = "${adminPath}/prjtrace/projectStatus")
public class ProjectStatusController extends BaseController {

//    @org.springframework.web.bind.annotation.InitBinder
//    public void InitBinder(WebDataBinder binder){
//        DateFormat df = new SimpleDateFormat("yyyy");
//        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
//        binder.registerCustomEditor(Date.class,dateEditor);
//    }

    @Autowired
    private ProjectStatusService projectStatusService;

    @ModelAttribute
    public ProjectStatus get(@RequestParam(required = false) String id) {
        ProjectStatus entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = projectStatusService.get(id);
        }
        if (entity == null) {
            entity = new ProjectStatus();

        }
        return entity;
    }

    @RequiresPermissions("prjtrace:projectStatus:view")
    @RequestMapping(value = {"list", ""})
    public String list(ProjectStatus projectStatus, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<ProjectStatus> page = projectStatusService.findPage(new Page<ProjectStatus>(request, response), projectStatus);
        model.addAttribute("page", page);
        return "modules/prjtrace/projectStatusList";
    }

    @RequiresPermissions("prjtrace:projectStatus:view")
    @RequestMapping(value = "form")
    public String form(ProjectStatus projectStatus, Model model) {

        projectStatus.setYear(DateUtils.getYear());
        model.addAttribute("projectStatus", projectStatus);
        return "modules/prjtrace/projectStatusForm";
    }

    @RequiresPermissions("prjtrace:projectStatus:edit")
    @RequestMapping(value = "save")
    public String save(ProjectStatus projectStatus, Model model, RedirectAttributes redirectAttributes) {
        logger.info("========projectStatus : " + projectStatus.getYear());
        if (!beanValidator(model, projectStatus)) {
            return form(projectStatus, model);
        }
        projectStatusService.save(projectStatus);
        addMessage(redirectAttributes, "保存项目状态成功");
        return "redirect:" + Global.getAdminPath() + "/prjtrace/projectStatus/?repage";
    }

    @RequiresPermissions("prjtrace:projectStatus:edit")
    @RequestMapping(value = "delete")
    public String delete(ProjectStatus projectStatus, RedirectAttributes redirectAttributes) {
        projectStatusService.delete(projectStatus);
        addMessage(redirectAttributes, "删除项目状态成功");
        return "redirect:" + Global.getAdminPath() + "/prjtrace/projectStatus/?repage";
    }

}