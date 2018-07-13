package com.qlmsoft.mbp.common.config;

import java.util.ArrayList;
import java.util.List;

public class PulicityMenu {

	private String name;
	private String code;
	private String url;

	private boolean active;

	private boolean hasSubMenu;

	private List<PulicityMenu> childs = new ArrayList<PulicityMenu>();

	public PulicityMenu(String name, String code, String url, boolean hasSubMenu) {
		super();
		this.name = name;
		this.url = url;
		this.code = code;
		this.hasSubMenu = hasSubMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isHasSubMenu() {
		return hasSubMenu;
	}

	public void setHasSubMenu(boolean hasSubMenu) {
		this.hasSubMenu = hasSubMenu;
	}

	public List<PulicityMenu> getChilds() {
		return childs;
	}

	public void setChilds(List<PulicityMenu> childs) {
		this.childs = childs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
