package com.mju.insurance.dao.consultApplication;

import java.util.List;

import com.mju.insurance.entity.consultApplication.ConsultApplication;

public interface ConsultApplicationDao {

    public boolean create(ConsultApplication consultApplication);
	public List<ConsultApplication> getByCustomerId(String customerId);
	public boolean delete(String id);

}
