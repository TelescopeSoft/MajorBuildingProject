package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.modules.project.bean.mohourd.ApZjsbbBean;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableApZjsbb;
import com.qlmsoft.mbp.modules.project.service.ApZjsbbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronhuang on 2018/8/26.
 */
@Service
public class ApZjsbbSynch extends MohourdBaseSynch {

    @Autowired
    ApZjsbbService service;


    @Override
    protected void resolveResponse(String decodeStr) {
        DataTableApZjsbb dataTable = (DataTableApZjsbb) XmlBuilder.xmlStrToObject(DataTableApZjsbb.class, decodeStr);
        if(dataTable != null && dataTable.getRows() != null){
            logger.info("dataTable.getRows():" + dataTable.getRows().size());
            for(ApZjsbbBean bean : dataTable.getRows()){
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
