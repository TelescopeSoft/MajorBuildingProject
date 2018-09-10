
package com.qlmsoft.mbp.modules.sys.utils;

import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.common.utils.SpringContextHolder;
import com.qlmsoft.mbp.modules.project.dao.CodeInfoDao;
import com.qlmsoft.mbp.modules.project.entity.CodeInfo;

import java.util.List;

/**
 * 项目字典类
 *
 * @author huang.zhengyu
 * @version 2018-08-29
 */
public class CodeInfoUtils {

    private static CodeInfoDao codeInfoDao = SpringContextHolder.getBean(CodeInfoDao.class);


    public static List<CodeInfo> getCodeInfoList(String type) {
        CodeInfo entity = new CodeInfo();
        entity.setCodeType(type);
        List<CodeInfo> result = codeInfoDao.findList(entity);
        return result;
    }

    /**
     * 返回字典列表（JSON）
     *
     * @param type
     * @return
     */
    public static String getDictListJson(String type) {
        return JsonMapper.toJsonString(getCodeInfoList(type));
    }

}
