package com.stone.test;
import java.util.ArrayList;
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
	
	@Test
	public void test09() throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ename", "A");
		map.put("sal", 2000);
		List<Emp> emps = empMapper.selectEmpByMap(map);
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test10() throws Exception {
		List<Emp> emps = empMapper.selectEmpByConditions("A", 2000);
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test11() throws Exception {
		//条件是1=1
		Emp e1 = new Emp();
		List<Emp> emps1 = empMapper.selectEmpIf(e1);
		for (Emp emp : emps1) {
			System.out.println(emp);
		}
		//条件是ename like %A%
		Emp e2 = new Emp();
		e2.setEname("A");
		List<Emp> emps2 = empMapper.selectEmpIf(e2);
		for (Emp emp : emps2) {
			System.out.println(emp);
		}
		//条件是sal>2000
		Emp e3 = new Emp();
		e3.setSal(2000.00);
		List<Emp> emps3 = empMapper.selectEmpIf(e3);
		for (Emp emp : emps3) {
			System.out.println(emp);
		}
		//条件是ename like %A% and sal>2000
		Emp e4 = new Emp();
		e4.setEname("A");
		e4.setSal(2000.00);
		List<Emp> emps4 = empMapper.selectEmpIf(e4);
		for (Emp emp : emps4) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test12() throws Exception {
		//条件是1=1
		Emp e1 = new Emp();
		List<Emp> emps1 = empMapper.selectEmpWhere(e1);
		for (Emp emp : emps1) {
			System.out.println(emp);
		}
		//条件是ename like %A%
		Emp e2 = new Emp();
		e2.setEname("A");
		List<Emp> emps2 = empMapper.selectEmpWhere(e2);
		for (Emp emp : emps2) {
			System.out.println(emp);
		}
		//条件是sal>2000
		Emp e3 = new Emp();
		e3.setSal(2000.00);
		List<Emp> emps3 = empMapper.selectEmpWhere(e3);
		for (Emp emp : emps3) {
			System.out.println(emp);
		}
		//条件是ename like %A% and sal>2000
		Emp e4 = new Emp();
		e4.setEname("A");
		e4.setSal(2000.00);
		List<Emp> emps4 = empMapper.selectEmpWhere(e4);
		for (Emp emp : emps4) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test13() throws Exception {
		//条件是1=0,没有返回结果
		Emp e1 = new Emp();
		List<Emp> emps1 = empMapper.selectEmpChoose(e1);
		for (Emp emp : emps1) {
			System.out.println(emp);
		}
		//条件是ename like %A%,有返回结果
		Emp e2 = new Emp();
		e2.setEname("A");
		List<Emp> emps2 = empMapper.selectEmpChoose(e2);
		for (Emp emp : emps2) {
			System.out.println(emp);
		}
		//条件是sal>2000,有返回结果
		Emp e3 = new Emp();
		e3.setSal(2000.00);
		List<Emp> emps3 = empMapper.selectEmpChoose(e3);
		for (Emp emp : emps3) {
			System.out.println(emp);
		}
		//条件是ename like %A% and sal>2000，加上了2个条件反而没有结果
		Emp e4 = new Emp();
		e4.setEname("A");
		e4.setSal(2000.00);
		List<Emp> emps4 = empMapper.selectEmpChoose(e4);
		for (Emp emp : emps4) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test14() throws Exception {
		Object[] empnos = new Object[] {7499,7521};
		List<Emp> emps = empMapper.selectEmpForeachArray(empnos);
		System.out.println(emps);
	}
	
	@Test
	public void test15() throws Exception {
		List<Integer> empnos = new ArrayList<Integer>();
		empnos.add(7499);
		empnos.add(7521);
		List<Emp> emps = empMapper.selectEmpForeachList(empnos);
		System.out.println(emps);
	}
	
	@Test
	public void test16() throws Exception {
		Emp emp1 = new Emp();
		emp1.setEmpno(7499);
		Emp emp2 = new Emp();
		emp2.setEmpno(7521);
		
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		
		emps = empMapper.selectEmpForeachList2(emps);
		System.out.println(emps);
	}
	
	@Test
	public void test17() throws Exception {
		Emp emp1 = new Emp();
		emp1.setEmpno(7499);
		Emp emp2 = new Emp();
		emp2.setEmpno(7521);
		
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		
		emps = empMapper.selectEmpBySQLFragment(emps);
		System.out.println(emps);
	}
}