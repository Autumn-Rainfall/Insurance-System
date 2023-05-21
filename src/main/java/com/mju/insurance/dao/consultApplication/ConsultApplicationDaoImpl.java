package com.mju.insurance.dao.consultApplication;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mju.insurance.common.mybatis.MyBatisConnectionFactory;
import com.mju.insurance.entity.consultApplication.ConsultApplication;

@Repository
public class ConsultApplicationDaoImpl implements ConsultApplicationDao {
	private SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

	private static final String Insert = "ConsultApplicationMapper.insert";
	private static final String selectByCustomerId = "ConsultApplicationMapper.selectByCustomerId";
	private static final String Delete = "ConsultApplicationMapper.deleteByConsultationId";
	
	@Override
	public boolean create(ConsultApplication consultApplication) {
		if(sqlSession.insert(Insert, consultApplication) == 1) {
        	sqlSession.commit(); // apply to Database
    		return true;
    	}
    	return false;
	}

	@Override
	public List<ConsultApplication> getByCustomerId(String customerId) {
		return sqlSession.selectList(selectByCustomerId, customerId);
	}

	@Override
	public boolean delete(String id) {
		if(sqlSession.delete(Delete, id) == 1) {
        	sqlSession.commit();
    		return true;
    	}
		return false;
	}

//	public ConsultApplicationDaoImpl() {
//		super.connect();
//	}
//	
//    public boolean create(ConsultApplication consultApplication) {
//        String query = String.format(
//                "insert into consult_application values (0, %s, '%s', '%s', '%s', '%s')",
//                consultApplication.getCustomerId(), consultApplication.getContent(), Timestamp.valueOf(consultApplication.getApplicationDate())
//                , Timestamp.valueOf(consultApplication.getConsultationDate()), consultApplication.getState().name()
//        );
//        return super.create(query);
//    }
//	
//    public boolean update(ConsultApplication consultApplication) {
//        String query = String.format(
//                "update consult_application set customer_id=%s, content='%s', application_date='%s', consultation_date='%s', state='%s' where id=%s",
//                consultApplication.getCustomerId(), consultApplication.getContent(), Timestamp.valueOf(consultApplication.getApplicationDate())
//                , Timestamp.valueOf(consultApplication.getConsultationDate()), consultApplication.getState().name(), consultApplication.getId()
//        );
//        return super.update(query);
//    }
//
//    public boolean delete(String id) {
//        String query = String.format("delete from consult_application where id=%s", id);
//        return super.delete(query);
//    }
//
//    public ArrayList<ConsultApplication> retrieveAll() {
//        try {
//            String query = "select * from consult_application";
//            ResultSet resultSet = super.retrieve(query);
//            if(resultSet==null) return null;
//            ArrayList<ConsultApplication> consultApplications = new ArrayList<>();
//            while (resultSet.next()) {
//            	ConsultApplication consultApplication = getCurrentConsultApplication(resultSet);
//            	consultApplications.add(consultApplication);
//            }
//            return consultApplications;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    public ConsultApplication retrieveById(String id) {
//        try {
//            String query = String.format("select * from consult_application where id=%s", id);
//            System.out.println(query);
//            ResultSet resultSet = super.retrieve(query);
//            if(resultSet==null || !resultSet.next()) return null;
//            ConsultApplication consultApplication = getCurrentConsultApplication(resultSet);
//            return consultApplication;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ArrayList<ConsultApplication> retrieveByCustomerId(String customerId) {
//        try {
//            String query = String.format("select * from consult_application where customer_id='%s'", customerId);
//            ResultSet resultSet = super.retrieve(query);
//            if(resultSet==null) return null;
//            ArrayList<ConsultApplication> consultApplications = new ArrayList<>();
//            while (resultSet.next()) {
//            	ConsultApplication consultApplication = getCurrentConsultApplication(resultSet);
//            	consultApplications.add(consultApplication);
//            }
//            return consultApplications;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//	
//    private ConsultApplication getCurrentConsultApplication(ResultSet resultSet) throws SQLException {
//        String id = resultSet.getString("id");
//        String customerId = resultSet.getString("customer_id");
//        String content = resultSet.getString("content");
//        LocalDateTime applicationDate = resultSet.getTimestamp("application_date").toLocalDateTime();
//        LocalDateTime consultationDate = resultSet.getTimestamp("consultation_date").toLocalDateTime();
//        ConsultApplicationState state = ConsultApplicationState.valueOf(resultSet.getString("state"));
//        
//        ConsultApplication consultApplication = new ConsultApplication();
//        consultApplication.setId(id);
//        consultApplication.setCustomerId(customerId);
//        consultApplication.setContent(content);
//        consultApplication.setApplicationDate(applicationDate);
//        consultApplication.setConsultationDate(consultationDate);
//        consultApplication.setState(state);
//        return consultApplication;
//    }

}
