package com.mju.insurance.entity.uw;

/**
 * @author wls43
 * @version 1.0
 * @created 09-5-2022 ���� 4:48:26
 */
public class UWDocument {

	private String id;
	private String name;
	private String path;
	private UWDocumentState uwDocumentState;
	private String uwId;

	public UWDocument(){
		this.uwDocumentState = UWDocumentState.UNDEFINED;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UWDocument) {
			return ((UWDocument) obj).getId().equals(this.id);
		}
		return false;
	}
	
	public boolean equalsAttributes(Object obj) {
		if(obj instanceof UWDocument) {
			UWDocument uWDocument = (UWDocument) obj;
			if(uWDocument.id.equals(this.id) &&
				uWDocument.name.equals(this.name) &&
				uWDocument.path.equals(this.path) &&
				uWDocument.uwDocumentState.equals(this.uwDocumentState) &&
				uWDocument.uwId.equals(this.uwId)
			) return true;
		} return false;
	}

	// getters setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public UWDocumentState getUwDocumentState() {
		return uwDocumentState;
	}
	public void setUwDocumentState(UWDocumentState uwDocumentState) {
		this.uwDocumentState = uwDocumentState;
	}
	public String getUwId() {
		return uwId;
	}
	public void setUwId(String uwId) {
		this.uwId = uwId;
	}
}