package com.mju.insurance.entity.insurance;

import java.util.ArrayList;

import com.mju.insurance.entity.customer.Customer;

public class Insurance {
	private InsuranceCategory insuranceCategory;
	private ArrayList<Clause> clauses = new ArrayList<>();
	private String id;
	private String name;
	private InsuranceState insuranceState = InsuranceState.BEFORE_AUDIT;

	public void addClause(Clause clause) { this.clauses.add(clause); }
	public void removeClause(Clause clause) {this.clauses.remove(clause);}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Insurance ) {
			return ((Insurance) obj).id.equals(this.id);
		}
		else return false;
	}
	public boolean equalsAttributes(Object obj) {
		if(obj instanceof Insurance) {
			Insurance other = (Insurance) obj;
			if (other.id.equals(this.id) &&
					other.name.equals(this.name) &&
					other.insuranceState.equals(this.insuranceState) &&
					other.insuranceCategory.equals(this.insuranceCategory)) return true;
		}
		return false;
	}
	public double calculateRatio(Customer customer) {
		switch (this.insuranceCategory) {
		case CAR:
			long carPrice = customer.getAdditionalInfo().getCarPrice();
			if(carPrice < 100000000L) return 0.9;
			else if(carPrice < 100000000L) return 1.0;
			else if(carPrice < 200000000L) return 1.1;
			else return 1.3;
		case FIRE:
			long housePrice = customer.getAdditionalInfo().getHousePrice();
			if(housePrice < 700000000L) return 1.0;
			else if(housePrice < 700000000L) return 1.2;
			else if(housePrice < 1000000000L) return 1.3;
			else if(housePrice < 5000000000L) return 1.5;
			else return 1.8;
		case DRIVER:
			long drivingCareer = customer.getAdditionalInfo().getDrivingCareer();
			if(drivingCareer > 20) return 0.7;
			else if(drivingCareer > 10) return 1.0;
			else if(drivingCareer > 5) return 1.2;
			else if(drivingCareer > 3) return 1.4;
			else if(drivingCareer > 1) return 1.7;
			else return 2;
		case MARINE:
			long shipPrice = customer.getAdditionalInfo().getShipPrice();
			if(shipPrice < 700000000L) return 1.0;
			else if(shipPrice < 700000000L) return 1.2;
			else if(shipPrice < 1000000000L) return 1.3;
			else if(shipPrice < 5000000000L) return 1.5;
			else return 1.8;
		default: break;
		}
		return 0;
	}
	// getters setters
	public InsuranceCategory getInsuranceCategory() {
		return insuranceCategory;
	}
	public void setInsuranceCategory(InsuranceCategory insuranceCategory) {
		this.insuranceCategory = insuranceCategory;
	}
	public ArrayList<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InsuranceState getInsuranceState() {
		return insuranceState;
	}
	public void setInsuranceState(InsuranceState insuranceState) {
		this.insuranceState = insuranceState;
	}
}