package com.stone.dao.impl;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.stone.dao.EmpMapper;
import com.stone.entity.Emp;
import com.stone.util.MyBatisUtil;

public class EmpMapperImpl implements EmpMapper {
	
	private SqlSession session;

	@Override
	public int insert(Emp emp) {
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			int result  = session.insert("com.stone.xml.EmpMapper.insert", emp);
			//3、SqlSession提交
			session.commit();
			return result;
		} finally {
			//4、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int insertSelective(Emp emp) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int insertEmp(Emp emp) {
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			int result = session.insert("com.stone.xml.EmpMapper.insertEmp", emp);
			//3、SqlSession提交
			session.commit();
			return result;
		} finally {
			//4、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int deleteByEmpno(int empno) {
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			int result = session.delete("com.stone.xml.EmpMapper.deleteByEmpno", empno);
			//3、SqlSession提交
			session.commit();
			return result;
		} finally {
			//4、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int update(Emp emp) throws Exception {
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			int result = session.update("com.stone.xml.EmpMapper.update", emp);
			//3、SqlSession提交
			session.commit();
			return result;
		} finally {
			//4、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Emp selectByEmpno(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> selectByEname(String ename) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp selectByMap(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> selectAllEmp() throws Exception {
		List<Emp> emps = null;
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			emps = session.selectList("com.stone.xml.EmpMapper.selectAllEmp");
		} finally {
			//3、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
		return emps;
	}

	@Override
	public Map<String, Emp> selectEmpMap() throws Exception {
		Map<String, Emp> empsMap = null;
		try {
			//1、use MyBatiUtil get SqlSession instance
			session = MyBatisUtil.getSqlSession();
			//2、操作
			empsMap = session.selectMap("com.stone.xml.EmpMapper.selectAllEmp","ename");
		} finally {
			//3、SqlSession关闭
			if (session != null) {
				session.close();
			}
		}
		return empsMap;
	}

	@Override
	public List<Emp> findAll(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
