package com.myer.eposwebservice.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.myer.eposwebservice.constants.DAOConstants;


/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
@Entity
@Table(name=DAOConstants.EPOS_WEB_WS_NOTIFICATIONS)
public class HealthCheckDetail {
	
	@Id
	@SequenceGenerator(name=DAOConstants.NOTIFICATION_SEQ,sequenceName=DAOConstants.NOTIFICATION_SEQ,allocationSize=1)
	@GeneratedValue(generator=DAOConstants.NOTIFICATION_SEQ, strategy=GenerationType.SEQUENCE)
	@Column(name = DAOConstants.NOTIFICATION_ID, unique = true, nullable = false)
	private Integer notificationId;
	
	@Column(name=DAOConstants.ACTION)
	private String action;
	
	@Column(name=DAOConstants.CATEGORY)
	private String category;
	
	@Column(name=DAOConstants.DISPLAY_LAST_CHECKTIME)
	private String displayLastCheckTime;
	
	@Column(name=DAOConstants.LAST_CHECK_TIME)
	private String lastCheckTime;
	
	@Column(name=DAOConstants.STATUS)
	private String status;

	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getDisplayLastCheckTime() {
		return displayLastCheckTime;
	}
	public void setDisplayLastCheckTime(String displayLastCheckTime) {
		this.displayLastCheckTime = displayLastCheckTime;
	}
	public String getLastCheckTime() {
		return lastCheckTime;
	}
	public void setLastCheckTime(String lastCheckTime) {
		this.lastCheckTime = lastCheckTime;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("class HealthCheckDetail[");
		s.append(action + ",");
		s.append(category + ",");
		s.append(displayLastCheckTime + ",");
		s.append(lastCheckTime + ",");
		s.append(status + "]");
		return s.toString();
	}	
}
