
package com.qlmsoft.mbp.common.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qlmsoft.mbp.modules.sys.entity.User;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 数据Entity类
 * @author aaron
 * @version 2018-12-28
 */
public abstract class NewDataEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	private Date gmtCreate;		// 创建时间
	private Date gmtModified;		// 更新时间

	public NewDataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public NewDataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
			this.createBy = user;
		}
		this.gmtModified = new Date();
		this.gmtCreate = this.gmtModified;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(){
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
		}
		this.gmtModified = new Date();
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}
