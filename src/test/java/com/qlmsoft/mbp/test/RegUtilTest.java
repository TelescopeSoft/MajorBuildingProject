package com.qlmsoft.mbp.test;

import com.qlmsoft.mbp.common.utils.RegUtils;
import com.qlmsoft.mbp.modules.sys.service.SystemService;

import java.util.List;

public class RegUtilTest {

	public static void main(String[] args) {

		String a = "锡行审投许〔2018〕35号";

		List<String> list = RegUtils.abstractApproveNum(a);
		for(String i : list){
			System.out.println(i);
		}
	}
}
