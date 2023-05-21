package com.mju.insurance.entity.contract;

import java.time.LocalDateTime;

public class Contract {
	private String id;
	private LocalDateTime contractDateTime;
	private LocalDateTime expirationDateTime;
	private String customerId;
	private String insuranceId;
	private ContractState state;
	
	public Contract() {
		this.setState(ContractState.NEW);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contract) {
			return ((Contract) obj).getId().equals(this.id);
		}
		return false;
	}
	
	// getters and setters
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public LocalDateTime getContractDateTime() {return contractDateTime;}
	public void setContractDateTime(LocalDateTime contractDateTime) {this.contractDateTime = contractDateTime;}
	public LocalDateTime getExpirationDateTime() {return expirationDateTime;}
	public void setExpirationDateTime(LocalDateTime expirationDateTime) {this.expirationDateTime = expirationDateTime;}
	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}
	public String getInsuranceId() {return insuranceId;}
	public void setInsuranceId(String insuranceId) {this.insuranceId = insuranceId;}
	public ContractState getState() {return state;}
	public void setState(ContractState state) {this.state = state;}
	
}
