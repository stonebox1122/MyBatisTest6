package com.stone.test;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stone.dao.EmpMapper;
import com.stone.entity.Emp;
import com.stone.util.MyBatisUtil;

public class EmpTest {
	private Date date = new Date();
	private EmpMapper empMapper;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() {
		sqlSession = MyBatisUtil.getSqlSession();
		empMapper = sqlSession.getMapper(EmpMapper.class);
	}
	
	@After
	public void tearDown() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test01() {
		Emp emp = new Emp();
		//emp.setEmpno(8900);
		emp.setEname("aaa");
		emp.setHiredate(new java.sql.Date(date.getTime()));
		emp.setJob("bbb");
		emp.setMgr(7902);
		emp.setSal(9999.00);
		emp.setComm(100.00);
		emp.setDeptno(80);
		empMapper.insert(emp);
		sqlSession.commit();
	}
	
	@Test
	public void test02() {
		empMapper.deleteByEmpno(8900);
		sqlSession.commit();
	}
	
	@Test
	public void test03() throws Exception {
		Emp emp = new Emp();
		emp.setEmpno(8899);
		emp.setEname("ccc");
		emp.setHiredate(new java.sql.Date(date.getTime()));
		emp.setJob("ddd");
		emp.setMgr(7902);
		emp.setSal(8888.00);
		emp.setComm(100.00);
		emp.setDeptno(80);
		empMapper.update(emp);
		sqlSession.commit();
	}
	
	@Test
	public void test04() throws Exception {
		List<Emp> emps = empMapper.selectAllEmp();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test06() throws Exception {
		Emp emp = empMapper.selectByEmpno(8899);
		System.out.println(emp);
	}
	
	@Test
	public void test07() throws Exception {
		List<Emp> emps = empMapper.selectByEname("A");
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test08() throws Exception {
		Emp emp = new Emp();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("empno", 31);
		emp = empMapper.selectByMap(map);
		System.out.println(emp);
	}
}
