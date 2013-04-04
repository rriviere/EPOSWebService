package com.myer.eposwebservice.batch;

import com.myer.eposwebservice.constants.URLConstants;


/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
public class HealthCheckBatch extends AbstractJSONFowardBatch{
  
	public String getRequestURI() {
		return URLConstants.EPOS_WEB_HEALTH_CHECK_JSON_URI;
	}
	
	public String getFowardURI() {
		return URLConstants.EPOS_WEB_SERVICE_HEALTH_CHECK_JSON_URI;
	}	
}