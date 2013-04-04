package com.myer.eposwebservice.constants;

/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
public class URLConstants {
	
	public static final String HTTP_STRING = "http://";
	
	public static final String EPOS_WEB_HOSTNAME = "localhost";
	public static final String EPOS_WEB_SERVICE_HOSTNAME = "localhost";
	
	public static final String EPOS_WEB_PORT = ":8080";
	public static final String EPOS_WEB_SERVICE_PORT = ":8080";	
	
	public static final String EPOS_WEB_CONTEXT_ROOT = "/EPOSWeb";
	public static final String EPOS_WEB_SERVICE_CONTEXT_ROOT = "/EPOSWebService";	
	
	public static final String EPOS_WEB_ROOT_URI = HTTP_STRING + EPOS_WEB_HOSTNAME + EPOS_WEB_PORT + EPOS_WEB_CONTEXT_ROOT;
	public static final String EPOS_WEB_SERVICE_ROOT_URI = HTTP_STRING + EPOS_WEB_SERVICE_HOSTNAME + EPOS_WEB_SERVICE_PORT + EPOS_WEB_SERVICE_CONTEXT_ROOT;
	
	//EPOS web uri's
	public static final String EPOS_WEB_HEALTH_CHECK_JSON_URI = EPOS_WEB_ROOT_URI + "/json/healthCheck";
	
	//EPOS web service uri's
	public static final String EPOS_WEB_SERVICE_HEALTH_CHECK_JSON_URI = EPOS_WEB_SERVICE_ROOT_URI + "/json/healthCheck.htm";
}
