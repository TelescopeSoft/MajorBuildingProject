
package com.qlmsoft.mbp.modules.prjtrace.entity;

import com.qlmsoft.mbp.common.persistence.NewDataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 跟踪项目表Entity
 * @author aaron
 * @version 2018-12-27
 */
public class ProjectProcess extends NewDataEntity<ProjectProcess> {
	
	private static final long serialVersionUID = 1L;
	private String month;		// 月份
	private String process;		// 进展
	private ProjectItem prj;		// 项目ID 父类

	
	public ProjectProcess() {
		super();
	}

	public ProjectProcess(String id){
		super(id);
	}

	public ProjectProcess(ProjectItem prj){
		this.prj = prj;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	@Length(min=0, max=500, message="进展长度必须介于 0 和 500 之间")
	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public ProjectItem getPrj() {
		return prj;
	}

	public void setPrj(ProjectItem prj) {
		this.prj = prj;
	}
}