package com.myer.eposwebservice.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myer.eposwebservice.constants.DAOConstants;


@Entity
@Table(name=DAOConstants.EPOS_WEB_STORE_TABLE_NAME)
public class Store {
	
	@Id
	@Column(name=DAOConstants.EPOS_WEB_STORE_STORE_COL_NAME)
	@GeneratedValue
	String storeno;
	
	@Column(name=DAOConstants.EPOS_WEB_STORE_NAME_COL_NAME)
	String storeName;
	
	public String getStoreno() {
		return storeno;
	}
	public void setStoreno(String storeno) {
		this.storeno = storeno;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
