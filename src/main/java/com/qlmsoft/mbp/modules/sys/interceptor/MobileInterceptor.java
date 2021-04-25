/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qlmsoft.mbp.common.service.BaseService;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.common.utils.UserAgentUtils;

/**
 * 手机端视图拦截器
 * @author ThinkGem
 * @version 2014-9-1
 */
public class MobileInterceptor extends BaseService implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null){
			// 如果是手机或平板访问的话，则跳转到手机视图页面。
//			if(UserAgentUtils.isMobileOrTablet(request) && !StringUtils.startsWithIgnoreCase(modelAndView.getViewName(), "redirect:")){
//				modelAndView.setViewName("mobile/" + modelAndView.getViewName());
//			}
			try{
				String ip = getRemoteIp(request);
				String requestUri = request.getServletPath();
				logger.info("ip : " + ip + "|requestUri:" + requestUri);
				if((requestUri.startsWith("/a")) &&
						!("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip) || "10.85.22.251".equals(ip)
								|| ip.startsWith("10.85.22."))){
					modelAndView.setViewName("error/401");
				}
			}catch (Exception e){
				logger.error("error :" , e);
				modelAndView.setViewName("error/401");
			}


		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {

	}


	private String getRemoteIp(HttpServletRequest request) {
		//只有通过了负载均衡或者HTTP代理才会添加该项
		String ip = request.getHeader("x-forwarded-for");
		//apache服务器才有这个请求头
		if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		//weblogic有这个请求头
		if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		//nginx代理有这个请求头
		if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
