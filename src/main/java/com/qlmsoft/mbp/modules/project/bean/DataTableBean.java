package com.qlmsoft.mbp.modules.project.bean;

import java.util.ArrayList;
import java.util.List;

public class DataTableBean<E> {

	private List<E> data = new ArrayList<E>();

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

}
