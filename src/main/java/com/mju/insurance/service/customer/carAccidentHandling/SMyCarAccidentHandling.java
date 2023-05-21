package com.mju.insurance.service.customer.carAccidentHandling;

import java.util.ArrayList;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dto.customer.MyCarAccidentHandlingDTO;
import com.mju.insurance.entity.carAccidentHandling.CarAccidentHandling;
import com.mju.insurance.entity.contract.Contract;

public interface SMyCarAccidentHandling {
	void applyCarAccidentHandling(MyCarAccidentHandlingDTO carAccidentHandling, String contractId);
//	boolean revokeMyCarAccidentHandling(String id, String customerId);
	ArrayList<CarAccidentHandling> getByCustomerId(String customerId) throws NullDataException;
	Contract getCarContract(String customerId) throws NullDataException;
}