package com.myer.eposwebservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Interceptor to time the request for servlet logging purposes.
 * @author Richard Riviere
 * @date 03/04/2013s
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final String ATTR_START_TIME = "startTime";
	private static final String ATTR_EXECUTE_TIME = "executeTime";
	
	/**
	 * Before the actual handler will be executed. This will set the start time.
	 */
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler)
	    throws Exception {
 
		long startTime = System.currentTimeMillis();
		request.setAttribute(ATTR_START_TIME, new Long(startTime));
		
		return true;
	}
 
	/**
	 * After the actual handler has been be executed. This will log the execute time.
	 */
	public void postHandle(
		HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView)
		throws Exception {
 
		long startTime = ((Long)request.getAttribute(ATTR_START_TIME)).longValue();
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
 
		//Log the timing and request path
		if(logger.isInfoEnabled()){
		   logger.info(request.getServletPath() + "," + request.getMethod() + "," + executeTime);
		}
	}
}
