package com.mju.insurance.dto.customer;

public class AccidentCarDTO {
	private String carNo;
	private long cost;
	private String ownerName;
	private String ownerPhoneNo;
	private String visitedShopName;
	
	public String getCarNo() { return carNo; }
	public void setCarNo(String carNo) { this.carNo = carNo; }
	public long getCost() { return cost; }
	public void setCost(long cost) { this.cost = cost; }
	public String getOwnerName() { return ownerName; }
	public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
	public String getOwnerPhoneNo() { return ownerPhoneNo; }
	public void setOwnerPhoneNo(String ownerPhoneNo) { this.ownerPhoneNo = ownerPhoneNo; }
	public String getVisitedShopName() { return visitedShopName; }
	public void setVisitedShopName(String visitedShopName) { this.visitedShopName = visitedShopName; }
}
