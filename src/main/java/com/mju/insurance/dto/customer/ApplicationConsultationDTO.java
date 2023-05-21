package com.mju.insurance.dto.customer;

import java.time.LocalDateTime;

import com.mju.insurance.entity.consultApplication.ConsultApplicationState;

public class ApplicationConsultationDTO {

	private String id;
	private String customerId;
	private String content;
	private LocalDateTime applicationDate;
	private LocalDateTime consultationDate;
	private ConsultApplicationState state;

	public ApplicationConsultationDTO(String customerId, String content, LocalDateTime consultationDate) {
//		this.id = id;
		this.customerId = customerId;
		this.content = content;
//		this.applicationDate = applicationDate;
		this.consultationDate = consultationDate;
//		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDateTime getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(LocalDateTime consultationDate) {
		this.consultationDate = consultationDate;
	}

	public Enum<ConsultApplicationState> getState() {
		return state;
	}

	public void setState(ConsultApplicationState state) {
		this.state = state;
	}
}
