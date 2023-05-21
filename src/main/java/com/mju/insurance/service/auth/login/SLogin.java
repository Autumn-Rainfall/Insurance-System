package com.mju.insurance.service.auth.login;

import com.mju.insurance.dto.auth.LoginDTO;
import com.mju.insurance.entity.customer.Customer;

public interface SLogin {
	Customer login(LoginDTO loginDTO);
}