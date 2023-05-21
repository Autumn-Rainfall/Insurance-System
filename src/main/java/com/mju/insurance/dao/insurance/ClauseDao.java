package com.mju.insurance.dao.insurance;

import java.util.List;

import com.mju.insurance.entity.insurance.Clause;

public interface ClauseDao {
	public List<Clause> getClauseByInsuranceId(String id);
}
