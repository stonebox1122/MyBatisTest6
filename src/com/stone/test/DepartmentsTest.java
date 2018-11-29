package com.stone.test;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.stone.dao.DepartmentsMapper;
import com.stone.entity.Departments;
import com.stone.util.MyBatisUtil;

public class DepartmentsTest {
	//private Date date = new Date();
	private DepartmentsMapper departmentsMapper;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() {
		sqlSession = MyBatisUtil.getSqlSession();
		departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
	}
	
	@After
	public void tearDown() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test01() {
		List<Departments> departments = departmentsMapper.selectDepartmentsById(80);
		System.out.println(departments);
	}
}