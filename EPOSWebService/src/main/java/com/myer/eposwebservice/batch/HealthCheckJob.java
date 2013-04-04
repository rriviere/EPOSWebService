package com.myer.eposwebservice.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
public class HealthCheckJob extends QuartzJobBean {
	private HealthCheckBatch healthCheckBatch;

	public void setHealthCheckBatch(HealthCheckBatch healthCheckBatch) {
		this.healthCheckBatch = healthCheckBatch;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		healthCheckBatch.execute();
	}
}