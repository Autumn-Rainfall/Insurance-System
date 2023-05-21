package com.mju.insurance.dao.carAccidentHandling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.carAccidentHandling.AccidentPerson;

@Repository
public class AccidentPersonDao extends Dao {
    private final String tableName = "accident_person";

    public AccidentPersonDao() {
        super.connect();
    }
    
    public String create(AccidentPerson accidentPerson){
    	String query = this.makeCreationQuery(accidentPerson);
    	return super.createAndGetId(query);
    }
    
    private String makeCreationQuery(AccidentPerson accidentPerson){
    	String query = String.format(
    			"insert into %s values (0, '%d', '%d', '%s', '%s', '%s')",
    			this.tableName,  Integer.parseInt(accidentPerson.getCarAccidentHandlingId()),
    			accidentPerson.getCost(), accidentPerson.getName(), accidentPerson.getPhoneNo(), accidentPerson.getVisitedHospitalName()
    			);
    	return query;
    }
    
	public ArrayList<AccidentPerson> getAccidentCarByCarAccidentHandlingId(String id) {
        try {
            String query = "select * from " + this.tableName + " where car_accident_handling_id = " + id;
            ResultSet resultSet = super.retrieve(query);
            if (resultSet == null) return null;
            ArrayList<AccidentPerson> accidentPeople = new ArrayList<>();
            while (resultSet.next()) {
                AccidentPerson accidentPerson = getCurrentRecord(resultSet);
                accidentPeople.add(accidentPerson);
            }
            return accidentPeople;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
	}

    private AccidentPerson getCurrentRecord(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String carAccidentHandlingId = resultSet.getString("car_accident_handling_id");
        long cost = Long.parseLong(resultSet.getString("cost"));
        String name = resultSet.getString("name");
        String phoneNo = resultSet.getString("phone_no");
        String visitedHospitalName = resultSet.getString("visited_hospital_name");

        AccidentPerson accidentPerson = new AccidentPerson();
        accidentPerson.setId(id);
        accidentPerson.setCarAccidentHandlingId(carAccidentHandlingId);
        accidentPerson.setCost(cost);
        accidentPerson.setName(name);
        accidentPerson.setPhoneNo(phoneNo);
        accidentPerson.setVisitedHospitalName(visitedHospitalName);
        return accidentPerson;
    }
}
