package com.mju.insurance.dao.customer;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.exception.invalidInput.InvalidException;
import com.mju.insurance.common.mybatis.MyBatisConnectionFactory;
import com.mju.insurance.entity.customer.AdditionalInfo;
import com.mju.insurance.entity.customer.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
	
	@Autowired
	private AdditionalInfoDao additionalInfoDao;

	private static final String Insert = "CustomerMapper.insert";
	private static final String SelectByColumnName = "CustomerMapper.selectByColumnName";
	private static final String SelectByEmail = "CustomerMapper.selectByEmail";
	
	@Override
    public boolean createCustomer(Customer customer) {
    	if(sqlSession.insert(Insert, customer) == 1) {
        	sqlSession.commit(); // apply to Database
    		additionalInfoDao.createAdditionalInfo(customer);
    		return true;
    	} return false; // insert failed
    }

	@Override
	public Customer getCustomerByColumnName(String column, String value) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("value", value);
		Customer customer = sqlSession.selectOne(SelectByColumnName, map);
		if(customer == null) return null;
		customer.setAdditionalInfo(additionalInfoDao.getAdditionalInfoByCustomerId(customer.getId()));
		return customer;
	}
	
	@Override
	public Customer getByEmail(String email) throws InvalidException {
		Customer customer = sqlSession.selectOne(SelectByEmail, email);
		if(customer == null) throw new InvalidException("Customer");
		AdditionalInfo additionalInfo = additionalInfoDao.getAdditionalInfoByCustomerId(customer.getId());
		customer.setAdditionalInfo(additionalInfo);
		return customer;
	}
}
