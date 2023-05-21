package com.mju.insurance.dao.carAccidentHandling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.carAccidentHandling.AccidentCar;
import com.mju.insurance.entity.carAccidentHandling.AccidentPerson;
import com.mju.insurance.entity.carAccidentHandling.CarAccidentHandling;
import com.mju.insurance.entity.carAccidentHandling.ECarAccidentHandlingState;

@Repository
public class CarAccidentHandlingDao extends Dao {
	//desc car_accident_handling;
	private final String tableName = "car_accident_handling";
	
	@Autowired AccidentCarDao accidentCarDao;
	@Autowired AccidentPersonDao accidentPersonDao;
	
	public CarAccidentHandlingDao()  {
		super.connect();
	}

	public void create(CarAccidentHandling carAccidentHandling) {
		String query = this.makeCreationQuery(carAccidentHandling, carAccidentHandling.getContractId());
		String carAccidentHandlingId = super.createAndGetId(query); // create car accident handling
		for(AccidentCar dto : carAccidentHandling.getAccidentCars()) {
			dto.setCarAccidentHandlingId(carAccidentHandlingId);
			accidentCarDao.create(dto);
		}
		for(AccidentPerson dto : carAccidentHandling.getAccidentPeople()) {
			dto.setCarAccidentHandlingId(carAccidentHandlingId);
			accidentPersonDao.create(dto);
		}
	}
	
	private String makeCreationQuery(CarAccidentHandling carAccidentHandling, String contractid){
		String query = String.format(
				"insert into %s values (0, '%d', '%s', '%s', '%s', '%s', '%d')",
				this.tableName,  Integer.parseInt(contractid), Timestamp.valueOf(carAccidentHandling.getRequestDate()), Timestamp.valueOf(carAccidentHandling.getAccidentDate()),
				carAccidentHandling.getAccidentContent(), carAccidentHandling.getAccidentLocation(), carAccidentHandling.getState().ordinal()
		);
		return query;
	}
	
	public ArrayList<CarAccidentHandling> getCarAccidentHandlings() throws NullDataException {
		try{
			String query = "select * from " + this.tableName;
			ResultSet resultSet = super.retrieve(query);
			if(resultSet==null) return null;
			ArrayList<CarAccidentHandling> carAccidentHandlings = new ArrayList<>();
			while(resultSet.next()){
				CarAccidentHandling carAccidentHandling = getCurrentRecord(resultSet);
	            ArrayList<AccidentCar> accidentCars = accidentCarDao.getAccidentCarByCarAccidentHandlingId(carAccidentHandling.getId());
	            carAccidentHandling.setAccidentCars(accidentCars);
	            ArrayList<AccidentPerson> accidentPerson = accidentPersonDao.getAccidentCarByCarAccidentHandlingId(carAccidentHandling.getId());
	            carAccidentHandling.setAccidentPeople(accidentPerson);
				carAccidentHandlings.add(carAccidentHandling);
			}
			if(carAccidentHandlings.size() == 0) throw new NullDataException("Car Accident Handling");
			return carAccidentHandlings;
		} catch (SQLException e) {
//			e.printStackTrace();
			return null;
		}
	}
	
	private CarAccidentHandling getCurrentRecord(ResultSet resultSet) throws SQLException {
		String id = resultSet.getString("id");
		String contractId = resultSet.getString("contract_id");
		LocalDateTime requestDate = resultSet.getTimestamp("request_date").toLocalDateTime();
		LocalDateTime accidentDate = resultSet.getTimestamp("accident_date").toLocalDateTime();
		String accidentContent = resultSet.getString("accident_content");
		String accidentLocation = resultSet.getString("accident_location");
		ECarAccidentHandlingState state = ECarAccidentHandlingState.values()[resultSet.getInt("state")];

		CarAccidentHandling carAccidentHandling = new CarAccidentHandling();
		carAccidentHandling.setId(id);
		carAccidentHandling.setContractId(contractId);
		carAccidentHandling.setRequestDate(requestDate);
		carAccidentHandling.setAccidentDate(accidentDate);
		carAccidentHandling.setAccidentContent(accidentContent);
		carAccidentHandling.setAccidentLocation(accidentLocation);
		carAccidentHandling.setState(state);
		return carAccidentHandling;
	}
}
