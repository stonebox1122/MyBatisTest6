package com.stone.orm;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class EmpTest {
	Date date = new Date();
	
	@Test
	public void test01() {
		EmpMapper empMapper = new EmpMapperImpl();
		Emp emp = new Emp();
		emp.setEmpno(8899);
		emp.setEname("aaa");
		emp.setHiredate(new java.sql.Date(date.getTime()));
		emp.setJob("bbb");
		emp.setMgr(7902);
		emp.setSal(9999.00);
		emp.setComm(100.00);
		emp.setDeptno(80);
		empMapper.insert(emp);
	}

}
