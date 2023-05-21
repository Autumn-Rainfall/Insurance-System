package com.mju.insurance.entity.customer;

/**
 * @author bigst
 *
 */
public class AdditionalInfo {
	
	private String id;
	private long carPrice;
	public long housePrice;
	public int drivingCareer;
	public long shipPrice;

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public long getCarPrice() { return carPrice; }
	public void setCarPrice(long carPrice) { this.carPrice = carPrice; }
	public long getHousePrice() { return housePrice; }
	public void setHousePrice(long housePrice) { this.housePrice = housePrice; }
	public int getDrivingCareer() { return drivingCareer; }
	public void setDrivingCareer(int drivingCareer) { this.drivingCareer = drivingCareer; }
	public long getShipPrice() { return shipPrice; }
	public void setShipPrice(long shipPrice) { this.shipPrice = shipPrice; }
}
