/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.entity.EnvironmentProtection;
import com.qlmsoft.mbp.modules.project.dao.EnvironmentProtectionDao;
import com.qlmsoft.mbp.modules.project.entity.EnvironmentProtectionRectify;
import com.qlmsoft.mbp.modules.project.dao.EnvironmentProtectionRectifyDao;

/**
 * 施工期环境保护措施Service
 * @author huang.zhengyu
 * @version 2018-08-20
 */
@Service
@Transactional(readOnly = true)
public class EnvironmentProtectionService extends CrudService<EnvironmentProtectionDao, EnvironmentProtection> {

	@Autowired
	private EnvironmentProtectionRectifyDao environmentProtectionRectifyDao;
	
	public EnvironmentProtection get(String id) {
		EnvironmentProtection environmentProtection = super.get(id);
		environmentProtection.setEnvironmentProtectionRectifyList(environmentProtectionRectifyDao.findList(new EnvironmentProtectionRectify(environmentProtection)));
		return environmentProtection;
	}

	public EnvironmentProtection getByPrjCode(String prjCode) {
		EnvironmentProtection environmentProtection = this.dao.getByPrjCode(prjCode);
		if(environmentProtection != null){
			environmentProtection.setEnvironmentProtectionRectifyList(environmentProtectionRectifyDao.findList(new EnvironmentProtectionRectify(environmentProtection)));
		}else {
			environmentProtection = new EnvironmentProtection();
		}
		return environmentProtection;
	}
	
	public List<EnvironmentProtection> findList(EnvironmentProtection environmentProtection) {
		return super.findList(environmentProtection);
	}
	
	public Page<EnvironmentProtection> findPage(Page<EnvironmentProtection> page, EnvironmentProtection environmentProtection) {
		return super.findPage(page, environmentProtection);
	}
	
	@Transactional(readOnly = false)
	public void save(EnvironmentProtection environmentProtection) {
		super.save(environmentProtection);
		for (EnvironmentProtectionRectify environmentProtectionRectify : environmentProtection.getEnvironmentProtectionRectifyList()){
			if (environmentProtectionRectify.getId() == null){
				continue;
			}
			if (EnvironmentProtectionRectify.DEL_FLAG_NORMAL.equals(environmentProtectionRectify.getDelFlag())){
				if (StringUtils.isBlank(environmentProtectionRectify.getId())){
					environmentProtectionRectify.setEnvProtect(environmentProtection);
					environmentProtectionRectify.preInsert();
					environmentProtectionRectifyDao.insert(environmentProtectionRectify);
				}else{
					environmentProtectionRectify.preUpdate();
					environmentProtectionRectifyDao.update(environmentProtectionRectify);
				}
			}else{
				environmentProtectionRectifyDao.delete(environmentProtectionRectify);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(EnvironmentProtection environmentProtection) {
		super.delete(environmentProtection);
		environmentProtectionRectifyDao.delete(new EnvironmentProtectionRectify(environmentProtection));
	}
	
}