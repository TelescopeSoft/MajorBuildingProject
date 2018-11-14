/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableBuildLicense;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableProjectFinish;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;
import com.qlmsoft.mbp.modules.project.service.ProjectBuilderLicenceService;
import com.qlmsoft.mbp.modules.project.service.ProjectFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronhuang on 2018/8/26.
 */
@Service
public class ProjectFinishSynch extends MohourdBaseSynch {

    @Autowired
    ProjectFinishService service;

    @Override
    protected void resolveResponse(String decodeStr) {
        DataTableProjectFinish dataTable = (DataTableProjectFinish) XmlBuilder.xmlStrToObject(DataTableProjectFinish.class, decodeStr);
        if(dataTable != null && dataTable.getRows() != null){
            logger.info("dataTable.getRows():" + dataTable.getRows().size());
            for(ProjectFinish bean : dataTable.getRows()){
                try{
                    service.checkDuplicatedAndSave(bean);
                }catch(Exception e){
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }

            }
        }
    }

}
