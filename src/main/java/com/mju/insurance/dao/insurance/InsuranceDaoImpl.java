package com.mju.insurance.dao.insurance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.insurance.CarInsurance;
import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.DriverInsurance;
import com.mju.insurance.entity.insurance.FireInsurance;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.entity.insurance.InsuranceCategory;
import com.mju.insurance.entity.insurance.InsuranceState;
import com.mju.insurance.entity.insurance.MarineInsurance;

@Repository
public class InsuranceDaoImpl extends Dao implements InsuranceDao {
//	private SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
//	
	@Autowired private ClauseDao clauseDao;
//
//	private static final String SelectAll = "InsuranceMapper.selectAll";
//	private static final String SelectByName = "InsuranceMapper.selectByName";
//	private static final String SelectById = "InsuranceMapper.selectById";
//
//	@Override
//	public List<Insurance> getInsurances() throws NullDataException {
//		List<Insurance> insurances = sqlSession.selectList(SelectAll);
//		if(insurances.size() == 0) throw new NullDataException("Insurance");
//		for (Insurance insurance : insurances)
//			insurance.setClauses((ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId()));
//		return insurances;
//	}
//
//	@Override
//	public Insurance getByName(String insName) throws NullDataException {
//		Insurance insurance = sqlSession.selectOne(SelectByName, insName);
//		if(insurance == null) throw new NullDataException("Insurance");
//		ArrayList<Clause> clauses = (ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId());
//		insurance.setClauses(clauses);
//		return insurance;
//	}
//
//	@Override
//	public Insurance getById(String insuranceId) throws NullDataException {
//		Insurance insurance = sqlSession.selectOne(SelectById, insuranceId);
//		if(insurance == null) throw new NullDataException("Insurance");
//		ArrayList<Clause> clauses = (ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId());
//		insurance.setClauses(clauses);
//		return insurance;
//	}
    public InsuranceDaoImpl() {
        super.connect();
    }
    
	@Override
	public List<Insurance> getInsurances() throws NullDataException {
		try {
	        String query = "select * from insurance";
	        ResultSet resultSet = super.retrieve(query);
	        if(resultSet==null) return null;
	        ArrayList<Insurance> insurances = new ArrayList<>();
	        while (resultSet.next()) {
	            Insurance insurance = getCurrentInsurance(resultSet);
	            insurances.add(insurance);
	        }
			if(insurances.size() == 0) throw new NullDataException("Insurance");
			for (Insurance insurance : insurances)
				insurance.setClauses((ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId()));
	        return insurances;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}

	@Override
	public Insurance getByName(String name) throws NullDataException {
        try {
            String query = String.format("select * from insurance where name='%s'", name);
            ResultSet resultSet = super.retrieve(query);
            if(resultSet==null || !resultSet.next()) return null;
            Insurance insurance = getCurrentInsurance(resultSet);
    		if(insurance == null) throw new NullDataException("Insurance");
    		ArrayList<Clause> clauses = (ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId());
    		insurance.setClauses(clauses);
            return insurance;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Insurance getById(String insuranceId) throws NullDataException {
		try {
	        String query = String.format("select * from insurance where id=%s", insuranceId);
	        ResultSet resultSet = super.retrieve(query);
	        if(resultSet==null || !resultSet.next()) return null;
	        Insurance insurance = getCurrentInsurance(resultSet);
			if(insurance == null) throw new NullDataException("Insurance");
			ArrayList<Clause> clauses = (ArrayList<Clause>) clauseDao.getClauseByInsuranceId(insurance.getId());
			insurance.setClauses(clauses);
			return insurance;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
    private Insurance getCurrentInsurance(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        InsuranceCategory insuranceCategory = InsuranceCategory.valueOf(resultSet.getString("insurance_category"));
        InsuranceState insuranceState = InsuranceState.valueOf(resultSet.getString("insurance_state"));
        Insurance insurance = null;
        switch (insuranceCategory) {
            case FIRE: insurance = new FireInsurance(); break;
            case MARINE: insurance = new MarineInsurance(); break;
            case CAR: insurance = new CarInsurance(); break;
            case DRIVER: insurance = new DriverInsurance(); break;
        }
        insurance.setId(id);
        insurance.setName(name);
        insurance.setInsuranceCategory(insuranceCategory);
        insurance.setInsuranceState(insuranceState);
        return insurance;
    }
}



///////////

