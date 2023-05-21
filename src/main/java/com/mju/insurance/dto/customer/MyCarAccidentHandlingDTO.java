package com.mju.insurance.dto.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.mju.insurance.entity.carAccidentHandling.ECarAccidentHandlingState;

public class MyCarAccidentHandlingDTO {
	private String id;
	private String accidentLocation;
	private String accidentContent;
	private LocalDateTime accidentDate;
	private LocalDateTime requestDate;
	private ECarAccidentHandlingState state;
	private ArrayList<AccidentCarDTO> accidentCars;
	private ArrayList<AccidentPersonDTO> accidentPeople;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getAccidentLocation() { return accidentLocation; }
	public void setAccidentLocation(String accidentLocation) { this.accidentLocation = accidentLocation; }
	public String getAccidentContent() { return accidentContent; }
	public void setAccidentContent(String accidentContent) { this.accidentContent = accidentContent; }
	public LocalDateTime getAccidentDate() { return accidentDate; }
	public void setAccidentDate(LocalDateTime accidentDate) { this.accidentDate = accidentDate; }
	public LocalDateTime getRequestDate() { return requestDate; }
	public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }
	public ECarAccidentHandlingState getState() { return state; }
	public void setState(ECarAccidentHandlingState state) { this.state = state; }
	public ArrayList<AccidentCarDTO> getAccidentCars() { return accidentCars; }
	public void setAccidentCars(ArrayList<AccidentCarDTO> accidentCars) { this.accidentCars = accidentCars; }
	public ArrayList<AccidentPersonDTO> getAccidentPeople() { return accidentPeople; }
	public void setAccidentPeople(ArrayList<AccidentPersonDTO> accidentPeople) { this.accidentPeople = accidentPeople; }
}
