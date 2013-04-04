package com.myer.eposwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myer.eposwebservice.constants.ControllerConstants;
import com.myer.eposwebservice.form.HealthCheck;
import com.myer.eposwebservice.service.HealthCheckManager;

/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
@Controller
@RequestMapping(ControllerConstants.EPOS_WEB_SERVICE_JSON_URI)
public class HealthCheckJSONController extends AbstractJSONController {
	
	@Autowired
	private HealthCheckManager healthCheckManager;
	
	@RequestMapping(value = ControllerConstants.EPOS_WEB_SERVICE_HEALTH_CHECK_URI, method = RequestMethod.POST)
	public @ResponseBody HealthCheck parseHealthCheck(@RequestBody HealthCheck request) {
        final HealthCheck result = new HealthCheck();
        result.setHealthCheckItems(request.getHealthCheckItems());  
        healthCheckManager.parseHealthCheck(result);	       
	    return result;
	} 	
}
