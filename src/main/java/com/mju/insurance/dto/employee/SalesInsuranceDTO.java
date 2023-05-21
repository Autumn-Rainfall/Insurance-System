package com.mju.insurance.dto.employee;

import com.mju.insurance.entity.insurance.InsuranceCategory;
import com.mju.insurance.entity.insurance.InsuranceState;

public class SalesInsuranceDTO {
	String id;
	String name;
	InsuranceCategory category;
	InsuranceState state;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	public void setCategory(InsuranceCategory insuranceCategory) { this.category = insuranceCategory; }
	public InsuranceCategory getCategory() { return category; }
	public void setState(InsuranceState insuranceState) { this.state = insuranceState; }
	public InsuranceState getState() { return state; }
}
