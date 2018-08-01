/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlmsoft.mbp.common.config.PulicityMenuInstance;
import com.qlmsoft.mbp.common.mapper.JsonMapper;
import com.qlmsoft.mbp.modules.project.bean.DataTableBean;
import com.qlmsoft.mbp.modules.project.entity.Expropriation;
import com.qlmsoft.mbp.modules.project.entity.PubTradeContent;
import com.qlmsoft.mbp.modules.project.entity.Trade;
import com.qlmsoft.mbp.modules.project.service.PubTradeContentService;
import com.qlmsoft.mbp.modules.project.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlmsoft.mbp.common.web.BaseController;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;
import com.qlmsoft.mbp.modules.project.service.TenderInfoService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目安监申报Controller
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Controller
public class PubTenderController extends BaseController {

	@Autowired
	private TenderInfoService tenderInfoService;

	@Autowired
	private TradeService tradeService;

	@Autowired
	private PubTradeContentService tradeContentService;

	@RequestMapping(value = "/publicity/projectdetailtender")
	public String detailApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String pkid = request.getParameter("pkid");
		List<TenderInfo> tenderList = tenderInfoService.findListByProjectPkid(pkid);
		model.addAttribute("tenderList", tenderList);
		return "modules/publicity/ProjectDetailTender";
	}

	@RequestMapping(value = "/publicity/tender")
	public String tender(Trade trade , HttpServletRequest request,
						 HttpServletResponse response, Model model) {

		model.addAttribute("menuList", PulicityMenuInstance.getMenus("tender"));
		model.addAttribute("trade", trade);
		return "modules/publicity/Tender";
	}

	@RequestMapping("/publicity/tender/list")
	@ResponseBody
	public String list(Trade display , HttpServletRequest request, HttpServletResponse response) {
		List<Trade> list = tradeService.findList(display);
		DataTableBean<Trade> result = new DataTableBean<Trade>();
		if (list != null && !list.isEmpty()) {
			result.setData(list);
			return JsonMapper.getInstance().toJson(result);
		} else {
			return "{\"data\":[]}";
		}
	}

	@RequestMapping(value = "/publicity/tenderdetail")
	public String tenderDetail(HttpServletRequest request,
								HttpServletResponse response, Model model) {
		String indexId = request.getParameter("indexId");
		String title = request.getParameter("title");
		PubTradeContent tradeContent = tradeContentService.getByIndexId(indexId);
		model.addAttribute("menuList", PulicityMenuInstance.getMenus("tender"));
		model.addAttribute("title", title);
		model.addAttribute("tradeContent", tradeContent);
		return "modules/publicity/TenderDetail";
	}

}