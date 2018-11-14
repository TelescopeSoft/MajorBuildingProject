/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.modules.project.bean.mohourd.DataTableTender;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;
import com.qlmsoft.mbp.modules.project.service.TenderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronhuang on 2018/8/26.
 */
@Service
public class TenderInfoSynch extends MohourdBaseSynch {

    @Autowired
    TenderInfoService service;

    @Override
    protected void resolveResponse(String decodeStr) {
        DataTableTender dataTable = (DataTableTender) XmlBuilder.xmlStrToObject(DataTableTender.class, decodeStr);
        if(dataTable != null && dataTable.getRows() != null){
            logger.info("dataTable.getRows():" + dataTable.getRows().size());
            for(TenderInfo bean : dataTable.getRows()){
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
