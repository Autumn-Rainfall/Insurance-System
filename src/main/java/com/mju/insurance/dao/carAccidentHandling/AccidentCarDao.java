package com.mju.insurance.dao.carAccidentHandling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.carAccidentHandling.AccidentCar;

@Repository
public class AccidentCarDao extends Dao {
    private final String tableName = "accident_car";

    public AccidentCarDao() {
        super.connect();
    }
    
    public boolean create(AccidentCar accidentCar){
    	String query = this.makeCreationQuery(accidentCar);
    	return super.create(query);
    }

    public String createAndGetId(AccidentCar accidentCar){
    	String query = this.makeCreationQuery(accidentCar);
    	return super.createAndGetId(query);
    }
    
    private String makeCreationQuery(AccidentCar accidentCar){
    	String query = String.format(
    			"insert into %s values (" +
    			"0, '%d', " +
    			"'%s', '%d', '%s', '%s', '%s')",
    			this.tableName,  Integer.parseInt(accidentCar.getCarAccidentHandlingId()),
    			accidentCar.getCarNo(), accidentCar.getCost(), accidentCar.getOwnerName(),  accidentCar.getOwnerPhoneNo(), accidentCar.getVisitedShopName()
    			);
    	return query;
    }
    
    public ArrayList<AccidentCar> getAccidentCarByCarAccidentHandlingId(String carAccidentHandlingId){
        try {
            String query = "select * from " + this.tableName + " where car_accident_handling_id=" + carAccidentHandlingId;
            ResultSet resultSet = super.retrieve(query);
            if (resultSet == null) return null;
            ArrayList<AccidentCar> accidentCars = new ArrayList<>();
            while (resultSet.next()) {
                AccidentCar accidentCar = getCurrentRecord(resultSet);
                accidentCars.add(accidentCar);
            }
            return accidentCars;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private AccidentCar getCurrentRecord(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String carAccidentHandlingId = resultSet.getString("car_accident_handling_id");
        String carNo = resultSet.getString("car_no");
        long cost = Long.parseLong(resultSet.getString("cost"));
        String ownerName = resultSet.getString("owner_name");
        String ownerPhoneNo = resultSet.getString("owner_phone_no");
        String visitedShopName = resultSet.getString("visited_shop_name");

        AccidentCar accidentCar = new AccidentCar();
        accidentCar.setId(id);
        accidentCar.setCarAccidentHandlingId(carAccidentHandlingId);
        accidentCar.setCarNo(carNo);
        accidentCar.setCost(cost);
        accidentCar.setOwnerName(ownerName);
        accidentCar.setOwnerPhoneNo(ownerPhoneNo);
        accidentCar.setVisitedShopName(visitedShopName);
        return accidentCar;
    }
}
