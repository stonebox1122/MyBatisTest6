package com.stone.orm;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	public static SqlSession getSqlSession() {
		try {
			if(factory == null) {
				//read main configuration file
				InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
				//create SqlSession Factory
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return factory.openSession();
	}
}