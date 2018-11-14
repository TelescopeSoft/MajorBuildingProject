/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.modules.project.bean.mohourd.ApAjsbbBean;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableApAjsbb;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableProjectFinish;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbHjssjdService;
import com.qlmsoft.mbp.modules.project.service.ApAjsbbService;
import com.qlmsoft.mbp.modules.project.service.ProjectFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronhuang on 2018/8/26.
 */
@Service
public class ApAjsbbSynch extends MohourdBaseSynch {

    @Autowired
    ApAjsbbService service;


    @Override
    protected void resolveResponse(String decodeStr) {
        DataTableApAjsbb dataTable = (DataTableApAjsbb) XmlBuilder.xmlStrToObject(DataTableApAjsbb.class, decodeStr);
        if(dataTable != null && dataTable.getRows() != null){
            logger.info("dataTable.getRows():" + dataTable.getRows().size());
            for(ApAjsbbBean bean : dataTable.getRows()){
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
