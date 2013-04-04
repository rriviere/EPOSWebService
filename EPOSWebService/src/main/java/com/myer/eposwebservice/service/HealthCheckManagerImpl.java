package com.myer.eposwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myer.eposwebservice.dao.HealthCheckDAO;
import com.myer.eposwebservice.form.HealthCheck;
import com.myer.eposwebservice.form.HealthCheckDetail;

/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
@Service
public class HealthCheckManagerImpl implements HealthCheckManager{

	@Autowired
	private HealthCheckDAO healthCheckDAO;
	
	@Transactional
	public void parseHealthCheck(HealthCheck healthCheck){
	
        System.out.println("parseHealthCheck \n\n ");
		//iterating over keys only
		/*for (String key : healthCheck.getHealthCheckItems().keySet()) {
		    System.out.println("Key = " + key);
		}*/

		//iterating over values only
		for (HealthCheckDetail value : healthCheck.getHealthCheckItems().values()) {
		    System.out.println("Value = " + value);
		    if (value.getStatus().equals("RED")){
		    	createRedRecord(value);
		    	updateRedRecord(value);		    	
		    }else if (value.getStatus().equals("GREEN")){
		    	//updateRedRecord(value);
		    }
		}
	}
	@Transactional
	 public void createRedRecord(HealthCheckDetail healthCheckDetail) {
		healthCheckDAO.createRedRecord(healthCheckDetail);
	 }
	@Transactional
	 public void updateRedRecord(HealthCheckDetail healthCheckDetail) {
		healthCheckDAO.updateRedRecord(healthCheckDetail);
	 }	
	
	 
}
