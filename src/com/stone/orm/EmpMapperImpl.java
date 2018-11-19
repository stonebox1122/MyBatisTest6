package com.stone.orm;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

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
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			session.insert("com.stone.orm.EmpMapper.insert", record);
			//3、SqlSession提交
			session.commit();
			return 1;
		} finally {
			//4、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
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
