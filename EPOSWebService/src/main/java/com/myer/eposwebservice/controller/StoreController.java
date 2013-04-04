package com.myer.eposwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myer.eposwebservice.form.Store;
import com.myer.eposwebservice.service.StoreManager;


/**
 * @author rriviere
 *
 */
@Controller
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	private StoreManager storeManager;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Store> getStores() {
		List<Store> stores = storeManager.getStores();
		return stores;
	} 	
}
