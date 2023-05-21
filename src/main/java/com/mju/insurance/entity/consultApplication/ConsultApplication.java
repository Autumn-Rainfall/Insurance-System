package com.mju.insurance.entity.consultApplication;

import java.time.LocalDateTime;

/**
 * @author bigst
 * @version 1.0
 * @created 09-5-2022 占쏙옙占쏙옙 4:48:25
 */
public class ConsultApplication {

	private String id;
	private String customerId;
	private String content;
	private LocalDateTime applicationDate = LocalDateTime.now();
	private LocalDateTime consultationDate;
	private ConsultApplicationState state;

	// constructor
	public ConsultApplication() {
		this.state = ConsultApplicationState.NEW;
	}
	
	// getters & setters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getCustomerId() { return customerId; }
	public void setCustomerId(String customerId) { this.customerId = customerId; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public LocalDateTime getApplicationDate() { return applicationDate; }
	public void setApplicationDate(LocalDateTime applicationDate) { this.applicationDate = applicationDate; }
	public LocalDateTime getConsultationDate() { return consultationDate; }
	public void setConsultationDate(LocalDateTime consultationDate) { this.consultationDate = consultationDate; }
	public Enum<ConsultApplicationState> getState() { return state; }
	public void setState(ConsultApplicationState state) { this.state = state; }
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ConsultApplication) {
			return ((ConsultApplication) obj).getId().equals(this.id);
		}
		return false;
	}
	
}//end ConsultApplication