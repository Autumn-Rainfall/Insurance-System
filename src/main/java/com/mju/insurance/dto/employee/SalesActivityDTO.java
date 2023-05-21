package com.mju.insurance.dto.employee;

import java.util.ArrayList;

import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.InsuranceCategory;
import com.mju.insurance.entity.insurance.InsuranceState;

public class SalesActivityDTO {
	String id;
	String name;
	InsuranceCategory category;
	InsuranceState state;
	ArrayList<Clause> clauses = new ArrayList<>();

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public InsuranceCategory getCategory() { return category; }
	public void setCategory(InsuranceCategory insuranceCategory) { this.category = insuranceCategory; }
	public InsuranceState getState() { return state; }
	public void setState(InsuranceState insuranceState) { this.state = insuranceState; }
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;

	}


//	String clauseId;
//	String clauseName;
//	ClauseCategory clauseCategory;
//	long clauseInsuredAmount;
//	long clausePremium;
//	public String getClauseId() { return clauseId; }
//	public void setClauseId(String clauseId) { this.clauseId = clauseId; }
//	public String getClauseName() { return clauseName; }
//	public void setClauseName(String clauseName) { this.clauseName = clauseName; }
//	public ClauseCategory getClauseCategory() { return clauseCategory; }
//	public void setClauseCategory(ClauseCategory clauseCategory) { this.clauseCategory = clauseCategory; }
//	public long getClauseInsuredAmount() { return clauseInsuredAmount; }
//	public void setClauseInsuredAmount(long insuredAmount) { this.clauseInsuredAmount = insuredAmount; }
//	public long getClausePremium() { return clausePremium; }
//	public void setClausePremium(long premium) { this.clausePremium = premium; }
}