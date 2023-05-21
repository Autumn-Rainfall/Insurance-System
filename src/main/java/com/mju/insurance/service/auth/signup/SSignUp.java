package com.mju.insurance.service.auth.signup;

import com.mju.insurance.dto.auth.SignUpDTO;

public interface SSignUp {
	boolean signUp(SignUpDTO signUpDTO);
	boolean isEmailDuplicated(String email);
	boolean isRegistrationNoDuplicated(String registrationNo);
	boolean isPhoneNoDuplicated(String phoneNo);
}
