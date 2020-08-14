/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectItem;
import com.qlmsoft.mbp.modules.prjtrace.dao.ProjectItemDao;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectProcess;
import com.qlmsoft.mbp.modules.prjtrace.dao.ProjectProcessDao;

/**
 * 跟踪项目表Service
 *
 * @author aaron
 * @version 2018-12-27
 */
@Service
@Transactional(readOnly = true)
public class ProjectItemService extends CrudService<ProjectItemDao, ProjectItem> {

    @Autowired
    private ProjectProcessDao projectProcessDao;

    public ProjectItem get(String id) {
        ProjectItem projectItem = super.get(id);
        if(projectItem != null){
            projectItem.setProjectProcessList(projectProcessDao.findList(new ProjectProcess(projectItem)));
        }
        return projectItem;
    }

    public List<ProjectItem> findList(ProjectItem projectItem) {
        return super.findList(projectItem);
    }

    public Page<ProjectItem> findPage(Page<ProjectItem> page, ProjectItem projectItem) {
        return super.findPage(page, projectItem);
    }

    @Transactional(readOnly = false)
    public void save(ProjectItem projectItem) {

        if (projectItem.getParent() != null && StringUtils.isNotEmpty(projectItem.getParent().getId())) {
            projectItem.setLevel(ProjectItem.LEVEL_SUB);
            projectItem.setParentIds(projectItem.getParent().getId()+",");
        }else {
            projectItem.setLevel(ProjectItem.LEVEL_ROOT);
        }

        super.save(projectItem);
        for (ProjectProcess projectProcess : projectItem.getProjectProcessList()) {
            if (projectProcess.getId() == null) {
                continue;
            }
            if (ProjectProcess.DEL_FLAG_NORMAL.equals(projectProcess.getDelFlag())) {
                if (StringUtils.isBlank(projectProcess.getId())) {
                    projectProcess.setPrj(projectItem);
                    projectProcess.preInsert();
                    projectProcessDao.insert(projectProcess);
                } else {
                    projectProcess.preUpdate();
                    projectProcessDao.update(projectProcess);
                }
            } else {
                projectProcessDao.delete(projectProcess);
            }
        }
    }

    @Transactional(readOnly = false)
    public void delete(ProjectItem projectItem) {
        super.delete(projectItem);
        projectProcessDao.delete(new ProjectProcess(projectItem));
    }

}