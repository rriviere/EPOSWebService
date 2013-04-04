package com.myer.eposwebservice.form;

import java.util.Map;

/**
 * @author rriviere
 *
 */

public class HealthCheck {
    private Map<String, HealthCheckDetail> healthCheckItems;

	public Map<String, HealthCheckDetail> getHealthCheckItems() {
		return healthCheckItems;
	}

	public void setHealthCheckItems(Map<String, HealthCheckDetail> healthCheckItems) {
		this.healthCheckItems = healthCheckItems;
	}
}
