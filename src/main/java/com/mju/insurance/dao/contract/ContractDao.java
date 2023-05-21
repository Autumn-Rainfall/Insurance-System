package com.mju.insurance.dao.contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.common.mybatis.MyBatisConnectionFactory;
import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.entity.contract.ContractState;

@Repository
public class ContractDao extends Dao {
	private static SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	private static final String Insert = "ContractMapper.insert";
	public static boolean add(Contract contract) {
		if(sqlSession.insert(Insert, contract) == 1) {
			sqlSession.commit(); // apply to Database
    		return true;
    	}
    	return false; // insert failed
	}

	public ContractDao() {
		super.connect();
	}
	
	public Contract getContractById(String id) throws NullDataException {
		try {
			String query = String.format("select * from contract where id=%s", id);
			ResultSet resultSet = super.retrieve(query);
			if (resultSet == null || !resultSet.next()) throw new NullDataException("Contract");
			Contract contract = getCurrentContract(resultSet);
			return contract;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Contract> getByCustomerId(String customerId) {
		try {
			String query = String.format("select * from contract where customer_id='%s'", customerId);
			ResultSet resultSet = super.retrieve(query);
			if (resultSet == null)
				return null;
			ArrayList<Contract> contracts = new ArrayList<>();
			while (resultSet.next()) {
				Contract contract = getCurrentContract(resultSet);
				contracts.add(contract);
			}
			return contracts;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
//
	private Contract getCurrentContract(ResultSet resultSet) throws SQLException {
		String id = resultSet.getString("id");
		LocalDateTime contractDateTime = resultSet.getTimestamp("contract_datetime").toLocalDateTime();
		LocalDateTime expirationDateTime = resultSet.getTimestamp("expiration_datetime").toLocalDateTime();
		String customerId = resultSet.getString("customer_id");
		String insuranceId = resultSet.getString("insurance_id");
		ContractState state = ContractState.valueOf(resultSet.getString("state"));

		Contract contract = new Contract();
		contract.setId(id);
		contract.setContractDateTime(contractDateTime);
		contract.setExpirationDateTime(expirationDateTime);
		contract.setCustomerId(customerId);
		contract.setInsuranceId(insuranceId);
		contract.setState(state);
		return contract;
	}

}