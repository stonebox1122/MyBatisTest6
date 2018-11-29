package com.stone.test;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.stone.dao.EmployeesMapper;
import com.stone.entity.Employees;
import com.stone.util.MyBatisUtil;

public class EmployeesTest {
	//private Date date = new Date();
	private EmployeesMapper employeesMapper;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() {
		sqlSession = MyBatisUtil.getSqlSession();
		employeesMapper = sqlSession.getMapper(EmployeesMapper.class);
	}
	
	@After
	public void tearDown() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test01() {
		Employees employees = employeesMapper.selectEmployeesById(100);
		System.out.println(employees);
		System.out.println(employees.getDepartments());
	}
	
	@Test
	public void test02() {
		List<Employees> employees = employeesMapper.selectManagerById(100);
		System.out.println(employees);
	}
}