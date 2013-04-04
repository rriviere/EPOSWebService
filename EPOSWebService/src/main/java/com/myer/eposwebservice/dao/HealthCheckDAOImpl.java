package com.myer.eposwebservice.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myer.eposwebservice.form.HealthCheckDetail;

/**
 * @author Richard Riviere
 * @date 04/04/2013
 */
@Repository
public class HealthCheckDAOImpl implements HealthCheckDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    public void createRedRecord(HealthCheckDetail healthCheckDetail) {
        sessionFactory.getCurrentSession().save(healthCheckDetail);
    }
    
    public void updateRedRecord(HealthCheckDetail healthCheckDetail) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("update com.myer.eposwebservice.form.HealthCheckDetail " +
							 " set resolved_time = :resolvedTime" +
							 " where action = :action" +
							 " and status = :status");
		
		query.setParameter("resolvedTime", healthCheckDetail.getLastCheckTime());
		query.setParameter("action", healthCheckDetail.getAction());
		query.setParameter("status", "RED");
		int result = query.executeUpdate();
        sessionFactory.getCurrentSession().update(healthCheckDetail);
    }
}
