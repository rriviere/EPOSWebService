package com.myer.eposwebservice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myer.eposwebservice.form.Store;


/**
 * @author rriviere
 *
 */
@Repository
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Store> getStores(){	
		List<Store> stores = sessionFactory.getCurrentSession()
				.createQuery("from com.myer.eposwebservice.form.Store").list();
		return stores;
	}	
}
