package com.myer.eposwebservice.dao;

import com.myer.eposwebservice.form.HealthCheckDetail;

/**
 * @author Richard Riviere
 * @date 04/04/2013
 */
public interface HealthCheckDAO  {
	 public void createRedRecord(HealthCheckDetail healthCheckDetail);
	 public void updateRedRecord(HealthCheckDetail healthCheckDetail);
}
