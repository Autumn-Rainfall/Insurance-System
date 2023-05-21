package com.mju.insurance.service.customer.consultApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.insurance.dao.consultApplication.ConsultApplicationDao;
import com.mju.insurance.dto.customer.ApplicationConsultationDTO;
import com.mju.insurance.dto.customer.ConsultationLookupDTO;
import com.mju.insurance.entity.consultApplication.ConsultApplication;
import com.mju.insurance.entity.consultApplication.ConsultApplicationState;

@Service
public class SMyConsultApplicationImpl implements SMyConsultApplication {
	
	@Autowired private ConsultApplicationDao consultApplicationDao;

	@Override
	public boolean applyConsultation(ApplicationConsultationDTO dto) {
		ConsultApplication consultApplication = new ConsultApplication();
		consultApplication.setCustomerId(dto.getCustomerId());
		consultApplication.setContent(dto.getContent());
		consultApplication.setApplicationDate(LocalDateTime.now());
		consultApplication.setConsultationDate(dto.getConsultationDate());
		consultApplication.setState(ConsultApplicationState.NEW);
		return consultApplicationDao.create(consultApplication);
	}

	@Override
	public ArrayList<ConsultationLookupDTO> getByCustomerId(String customerId) {
		ArrayList<ConsultApplication> consultationList = (ArrayList<ConsultApplication>) consultApplicationDao
				.getByCustomerId(customerId);
		ArrayList<ConsultationLookupDTO> dtos = new ArrayList<>();
		for (ConsultApplication consultation : consultationList) {
			ConsultationLookupDTO dto = new ConsultationLookupDTO();
			dto.setId(consultation.getId());
			dto.setContent(consultation.getContent());
			dto.setApplicationDate(consultation.getApplicationDate());
			dto.setConsultationDate(consultation.getConsultationDate());
			dto.setState((ConsultApplicationState) consultation.getState());
			dtos.add(dto);
		} return dtos;
	}

	@Override
	public boolean deleteMyConsultation(String id) {
		return consultApplicationDao.delete(id);
	}
}
