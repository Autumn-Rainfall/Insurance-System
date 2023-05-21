package com.mju.insurance.dao.insurance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mju.insurance.dao.Dao;
import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.ClauseCategory;

@Repository
public class ClauseDaoImpl extends Dao implements ClauseDao {
//	private SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
//
//	private static final String SelectAllByInsuranceId = "ClauseMapper.selectAllByInsuranceId";
//
//	@Override
//	public List<Clause> getClauseByInsuranceId(String insuranceId) {
//		return sqlSession.selectList(SelectAllByInsuranceId, insuranceId);
//	}
    public ClauseDaoImpl() {
        super.connect();
    }

	@Override
	public List<Clause> getClauseByInsuranceId(String insuranceId) {
		try {
            String query = "select * from clause where insurance_id=" + insuranceId;
            ResultSet resultSet = super.retrieve(query);
            if (resultSet == null) return null;
            ArrayList<Clause> clauses = new ArrayList<>();
            while (resultSet.next()) {
                Clause clause = getCurrentClause(resultSet);
                clauses.add(clause);
            }
            return clauses;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
	}
	
    private Clause getCurrentClause(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        ClauseCategory clauseCategory = ClauseCategory.valueOf(resultSet.getString("clause_category"));
        long insuredAmount = Long.parseLong(resultSet.getString("insured_amount"));
        long premium = Long.parseLong(resultSet.getString("premium"));
        String insuranceId = resultSet.getString("insurance_id");
        Clause clause = new Clause();
        clause.setId(id);
        clause.setName(name);
        clause.setClauseCategory(clauseCategory);
        clause.setInsuredAmount(insuredAmount);
        clause.setPremium(premium);
        clause.setInsuranceId(insuranceId);
        return clause;
    }
}
