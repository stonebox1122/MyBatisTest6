package com.stone.orm;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMapperImpl implements EmpMapper {
	
	private SqlSession session;

	@Override
	public long countByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Emp record) {
		try {
			//1、读取主配置文件
			InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
			//2、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3、创建SqlSession对象
			SqlSession session = sqlSessionFactory.openSession();
			//4、操作
			session.insert("com.stone.orm.EmpMapper.insert", record);
			//5、SqlSession提交
			session.commit();
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//6、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

	@Override
	public int insertSelective(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Emp> selectByExample(EmpExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Emp record, EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Emp record, EmpExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

}
