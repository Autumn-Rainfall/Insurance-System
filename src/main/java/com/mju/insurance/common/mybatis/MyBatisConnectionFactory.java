package com.mju.insurance.common.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try { initialize(); }
		catch(IOException ioException) { ioException.printStackTrace(); }
	}
	
	private static void initialize() throws IOException {
		String resource = "Config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory() { return sqlSessionFactory; }
	
}