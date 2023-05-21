package com.mju.insurance.dao.insurance;

import java.util.List;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.entity.insurance.Insurance;

public interface InsuranceDao {
	public List<Insurance> getInsurances() throws NullDataException;
	public Insurance getByName(String name) throws NullDataException;
	public Insurance getById(String insuranceId) throws NullDataException;
}
