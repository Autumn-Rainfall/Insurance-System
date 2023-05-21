package com.mju.insurance.entity.cancelApplication;

import java.time.LocalDateTime;

/**
 * @author bigst
 * @version 1.0
 * @created 09-5-2022 �뜝�룞�삕�뜝�룞�삕 4:48:25
 */
public class CancelApplication {

	private String id;
	private String contractId;
	private LocalDateTime applicationDate = LocalDateTime.now();
	private CancelApplicationState state;

	// constructor
	public CancelApplication(){
		this.state = CancelApplicationState.NEW;
	}
	
	// getters & setters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getContractId() { return contractId; }
	public void setContractId(String contractId) { this.contractId = contractId; }
	public LocalDateTime getApplicationDate() { return applicationDate; }
	public void setApplicationDate(LocalDateTime applicationDate) { this.applicationDate = applicationDate; }
	public CancelApplicationState getState() { return state; }
	public void setState(CancelApplicationState state) { this.state = state; }
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CancelApplication) {
			return ((CancelApplication) obj).getId().equals(this.id);
		}
		return false;
	}

}