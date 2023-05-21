package com.mju.insurance.service.customer.consultApplication;

import java.util.ArrayList;

import com.mju.insurance.dto.customer.ApplicationConsultationDTO;
import com.mju.insurance.dto.customer.ConsultationLookupDTO;

public interface SMyConsultApplication {
	ArrayList<ConsultationLookupDTO> getByCustomerId(String customerId);
	boolean deleteMyConsultation(String id);
	boolean applyConsultation(ApplicationConsultationDTO dto);
}
