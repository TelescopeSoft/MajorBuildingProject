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
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetail;
import com.qlmsoft.mbp.modules.project.dao.ExpropriationDetailDao;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetailInfo;
import com.qlmsoft.mbp.modules.project.dao.ExpropriationDetailInfoDao;

/**
 * 征地信息Service
 * @author huangzhengyu
 * @version 2018-07-24
 */
@Service
@Transactional(readOnly = true)
public class ExpropriationDetailService extends CrudService<ExpropriationDetailDao, ExpropriationDetail> {

	@Autowired
	private ExpropriationDetailInfoDao expropriationDetailInfoDao;
	
	public ExpropriationDetail get(String id) {
		ExpropriationDetail expropriationDetail = super.get(id);
		expropriationDetail.setExpropriationDetailInfoList(expropriationDetailInfoDao.findList(new ExpropriationDetailInfo(expropriationDetail.getId())));
		return expropriationDetail;
	}

	public ExpropriationDetail getByLcid(String lcid) {
		ExpropriationDetail detail = new ExpropriationDetail();
		detail.setLcid(lcid);
		ExpropriationDetail expropriationDetail = this.dao.getByCondition(detail);
		ExpropriationDetailInfo detailInfo = new ExpropriationDetailInfo();
		detailInfo.setLcid(lcid);
		expropriationDetail.setExpropriationDetailInfoList(expropriationDetailInfoDao.findList(detailInfo));
		return expropriationDetail;
	}
	
	public List<ExpropriationDetail> findList(ExpropriationDetail expropriationDetail) {
		return super.findList(expropriationDetail);
	}
	
	public Page<ExpropriationDetail> findPage(Page<ExpropriationDetail> page, ExpropriationDetail expropriationDetail) {
		return super.findPage(page, expropriationDetail);
	}
	
	@Transactional(readOnly = false)
	public void save(ExpropriationDetail expropriationDetail) {
		super.save(expropriationDetail);
		for (ExpropriationDetailInfo expropriationDetailInfo : expropriationDetail.getExpropriationDetailInfoList()){
			expropriationDetailInfo.setLcid(expropriationDetail.getLcid());
			expropriationDetailInfo.preInsert();
			expropriationDetailInfoDao.insert(expropriationDetailInfo);
		}
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(ExpropriationDetail expropriationDetail) {
		ExpropriationDetail existed = this.dao.getByCondition(expropriationDetail);
		if (existed == null) {
			super.save(expropriationDetail);
		}

		//征地信息相关的信息会更新
		for (ExpropriationDetailInfo expropriationDetailInfo : expropriationDetail.getExpropriationDetailInfoList()){
			expropriationDetailInfo.setLcid(expropriationDetail.getLcid());
			ExpropriationDetailInfo existedDetailInfo = expropriationDetailInfoDao.getByCondition(expropriationDetailInfo);

			if(existedDetailInfo == null){
				expropriationDetailInfo.preInsert();
				expropriationDetailInfoDao.insert(expropriationDetailInfo);
			}

		}
	}
	
	@Transactional(readOnly = false)
	public void delete(ExpropriationDetail expropriationDetail) {
		super.delete(expropriationDetail);
		expropriationDetailInfoDao.delete(new ExpropriationDetailInfo(expropriationDetail.getId()));
	}

	/**
	 * 获取征地告知书
	 * @return
	 */
	public List<ExpropriationDetailInfo> getNotice() {
		return getByContent("征地告知书");
	}

	/**
	 * 获取征收土地公告
	 * @return
	 */
	public List<ExpropriationDetailInfo> getAnnouncement() {
		return getByContent("征地公告");
	}

	/**
	 * 获取征地告知书
	 * @return
	 */
	public List<ExpropriationDetailInfo> getCompensationplan() {
		return getByContent("安置补偿方案公告");
	}

	public List<ExpropriationDetailInfo> getByContent(String content) {
		ExpropriationDetailInfo display = new ExpropriationDetailInfo();
		display.setContent(content);
		return expropriationDetailInfoDao.findList(display);
	}
	
}