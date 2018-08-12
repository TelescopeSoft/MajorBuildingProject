package com.qlmsoft.mbp.common.config;

import java.util.ArrayList;
import java.util.List;

public class PulicityMenuInstance {

	private static PulicityMenuInstance global = new PulicityMenuInstance();
	private static List<PulicityMenu> list = null;

	static {

		list = new ArrayList<PulicityMenu>();

//		PulicityMenu project = new PulicityMenu("项目列表", "index", "index", false);
		PulicityMenu project = new PulicityMenu("项目列表", "project", "project", false);
		list.add(project);

		PulicityMenu guide = new PulicityMenu("批准服务", "approveguide",
				"approveguide", false);
		list.add(guide);

//		PulicityMenu approveResult = new PulicityMenu("批准结果", "approveresult",
//				"approveresult", false);
		PulicityMenu approveResult = new PulicityMenu("批准结果", "approveresult2",
				"approveresult2", false);

		list.add(approveResult);

		PulicityMenu tender = new PulicityMenu("招标投标", "tender", "tender",
				false);
		list.add(tender);

		PulicityMenu land = new PulicityMenu("土地征收", "landexpropriation",
				"landexpropriation", true);
		PulicityMenu landinfo = new PulicityMenu("征地信息", "expropriationinfo",
				"expropriationinfo", false);
		PulicityMenu expropriationnotice = new PulicityMenu("征地告知书", "expropriationnotice",
				"expropriationnotice", false);
		PulicityMenu landannouncement = new PulicityMenu("征收土地公告", "landannouncement",
				"landannouncement", false);
		PulicityMenu compensationplan = new PulicityMenu("安置补偿方案公告", "compensationplan",
				"compensationplan", false);

		land.getChilds().add(landinfo);
		land.getChilds().add(expropriationnotice);
		land.getChilds().add(landannouncement);
		land.getChilds().add(compensationplan);
		list.add(land);

		/**
		PulicityMenu designchange = new PulicityMenu("重大设计变更", "designchange",
				"designchange", false);
		list.add(designchange);*/

		PulicityMenu construction = new PulicityMenu("施工信息", "construction",
				"construction", false);
		list.add(construction);

		PulicityMenu qualitysafty = new PulicityMenu("质量安全监督", "qualitysafty",
				"qualitysafty", true);

		PulicityMenu quality = new PulicityMenu("质量监督", "quality", "quality",
				false);
		PulicityMenu safyty = new PulicityMenu("安全监督", "safty", "safty", false);


//		PulicityMenu adminpenalty = new PulicityMenu("行政处罚", "adminpenalty",
//				"adminpenalty", false);

		qualitysafty.getChilds().add(quality);
		qualitysafty.getChilds().add(safyty);
//		qualitysafty.getChilds().add(adminpenalty);

		list.add(qualitysafty);

		PulicityMenu adminpenalty = new PulicityMenu("行政处罚", "adminpenalty",
				"adminpenalty", false);
		list.add(adminpenalty);

		PulicityMenu finish = new PulicityMenu("竣工信息", "finish", "finish",
				false);
		list.add(finish);

	}

	public static PulicityMenuInstance getInstance() {
		// 初始化菜单
		if (global == null) {
			global = new PulicityMenuInstance();
		}
		return global;
	}

	public static List<PulicityMenu> getMenus(String code) {

		for (PulicityMenu menu : list) {
			if (menu.getCode().equalsIgnoreCase(code)) {
				menu.setActive(true);
			} else {
				menu.setActive(false);
			}
		}

		return list;

	}

}
