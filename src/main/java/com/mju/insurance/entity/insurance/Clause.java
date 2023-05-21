package com.mju.insurance.entity.insurance;

/**
 * @author wls43
 * @version 1.0
 * @created 09-5-2022 ���� 4:48:25
 */
public class Clause {
	private ClauseCategory clauseCategory;
	private String id;
	private long insuredAmount;
	private long premium;
	private String name;
	private String insuranceId;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Clause) {
			return ((Clause) obj).id.equals(this.id);
		}
		return false;

	}

	public boolean equalsAttributes(Object obj) {
		if (obj instanceof Clause ) {
			Clause other = (Clause) obj;
			if(other.id.equals(this.id) &&
					other.name.equals(this.name) &&
					other.clauseCategory.equals(this.clauseCategory) &&
					other.insuredAmount == this.insuredAmount &&
					other.premium == this.premium) return true;
		}
		return false;
	}

	// getters & setters
	public ClauseCategory getClauseCategory() {
		return clauseCategory;
	}
	public void setClauseCategory(ClauseCategory clauseCategory) {
		this.clauseCategory = clauseCategory;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(long insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	public long getPremium() {
		return premium;
	}
	public void setPremium(long premium) {
		this.premium = premium;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
}