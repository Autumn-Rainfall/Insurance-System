package com.mju.insurance.dao.customer;

import com.mju.insurance.common.exception.invalidInput.InvalidException;
import com.mju.insurance.entity.customer.Customer;

public interface CustomerDao {
	public boolean createCustomer(Customer customer);
	public Customer getCustomerByColumnName(String column, String value);
	public Customer getByEmail(String email) throws InvalidException;
}
