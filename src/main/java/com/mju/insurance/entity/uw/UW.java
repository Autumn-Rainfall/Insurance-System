package com.mju.insurance.entity.uw;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UW {
	private String id = "UW"+System.currentTimeMillis();
	private UWState uwState;
	private ArrayList<UWDocument> documents = new ArrayList<>();
	private LocalDateTime requestDateTime = LocalDateTime.now();
	private String contractId;

	public UW() {
		this.uwState = UWState.UNDEFINED;
	}

	public void addDocument(UWDocument uwDocument) {
		this.documents.add(uwDocument);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UW) {
			return ((UW) obj).getId().equals(this.id);
		}
		return false;
	}
	
	public boolean equalsAttributes(Object obj) {
		if(obj instanceof UW) {
			UW uw = (UW) obj;
			if(uw.id.equals(this.id) &&
				uw.requestDateTime.equals(this.requestDateTime) &&
				uw.uwState.equals(this.uwState) &&
				uw.contractId.equals(this.contractId)
			) return true;
		} return false;
	}
	
	// getters & setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UWState getUwState() {
		return uwState;
	}
	public void setUwState(UWState uwState) {
		this.uwState = uwState;
	}
	public ArrayList<UWDocument> getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList<UWDocument> documents) {
		this.documents = documents;
	}
	public LocalDateTime getRequestDateTime() {
		return requestDateTime;
	}
	public void setRequestDateTime(LocalDateTime requestDateTime) {
		this.requestDateTime = requestDateTime;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
}