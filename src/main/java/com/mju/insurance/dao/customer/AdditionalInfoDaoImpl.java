package com.mju.insurance.dao.customer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.mybatis.MyBatisConnectionFactory;
import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.customer.AdditionalInfo;
import com.mju.insurance.entity.customer.Customer;

@Repository
public class AdditionalInfoDaoImpl extends Dao implements AdditionalInfoDao {
	private SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

	private static final String SelectByCustomerId = "AdditionalInfoMapper.selectByCustomerId";
	
	public AdditionalInfoDaoImpl() {
		super.connect();
	}

	@Override
	public void createAdditionalInfo(Customer customer) {
		AdditionalInfo additionalInfo = customer.getAdditionalInfo();
	    String query = String.format(
	            "insert into additional_info values (0, %s, %s, %s, %s, %s)",
	            customer.getId(), additionalInfo.getCarPrice(), additionalInfo.getHousePrice(),
	            additionalInfo.getDrivingCareer(), additionalInfo.getShipPrice()
	    );
	    additionalInfo.setId(super.createAndGetId(query));
	}

    public AdditionalInfo getAdditionalInfoByCustomerId(String customerId) {
		return sqlSession.selectOne(SelectByCustomerId, customerId);
    }
}
