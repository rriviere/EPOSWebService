package com.myer.eposwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myer.eposwebservice.dao.StoreDAO;
import com.myer.eposwebservice.form.Store;


@Service
public class StoreManagerImpl implements StoreManager{
	
	@Autowired
	private StoreDAO storeDAO;
	
	@Transactional
	public List<Store> getStores() {
		return storeDAO.getStores();
	}
	
}
