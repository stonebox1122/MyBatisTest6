package com.stone.test;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import com.stone.dao.EmpMapper;
import com.stone.dao.impl.EmpMapperImpl;
import com.stone.entity.Emp;

public class EmpTest {
	Date date = new Date();
	
	@Test
	public void test01() {
		EmpMapper empMapper = new EmpMapperImpl();
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
	}
	
	@Test
	public void test02() {
		EmpMapper empMapper = new EmpMapperImpl();
		empMapper.deleteByEmpno(8900);
	}
	
	@Test
	public void test03() throws Exception {
		EmpMapper empMapper = new EmpMapperImpl();
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
	}
	
	@Test
	public void test04() throws Exception {
		EmpMapper empMapper = new EmpMapperImpl();
		List<Emp> emps = empMapper.selectAllEmp();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test05() throws Exception {
		EmpMapper empMapper = new EmpMapperImpl();
		Map<String,Emp> map = empMapper.selectEmpMap();
		Emp emp = map.get("ccc");
		System.out.println(emp);
	}
}
