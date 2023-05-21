package com.mju.insurance.dao.customer;

import com.mju.insurance.entity.customer.AdditionalInfo;
import com.mju.insurance.entity.customer.Customer;

public interface AdditionalInfoDao {
	public AdditionalInfo getAdditionalInfoByCustomerId(String customerId);
    public void createAdditionalInfo(Customer customer);
}
