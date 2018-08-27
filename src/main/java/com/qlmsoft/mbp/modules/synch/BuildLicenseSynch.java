package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableBuildLicense;
import com.qlmsoft.mbp.modules.project.bean.mohourd.ProjectBuilderLicenseBean;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;
import com.qlmsoft.mbp.modules.project.service.ProjectBuilderLicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronhuang on 2018/8/26.
 */
@Service
public class BuildLicenseSynch extends MohourdBaseSynch {

    @Autowired
    ProjectBuilderLicenceService service;

    @Override
    protected void resolveResponse(String decodeStr) {
        DataTableBuildLicense dataTable = (DataTableBuildLicense) XmlBuilder.xmlStrToObject(DataTableBuildLicense.class, decodeStr);
        if(dataTable != null && dataTable.getRows() != null){
            logger.info("dataTable.getRows():" + dataTable.getRows().size());
            for(ProjectBuilderLicenseBean bean : dataTable.getRows()){
                if(bean.getBuilderLicense() != null){
                    try{
                        service.checkDuplicatedAndSave(bean.getBuilderLicense());
                    }catch(Exception e){
                        e.printStackTrace();
                        logger.error(e.getMessage());
                    }

                }

            }
        }
    }

}
