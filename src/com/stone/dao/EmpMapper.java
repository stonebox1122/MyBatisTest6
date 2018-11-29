package com.stone.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;
import com.stone.entity.Emp;

public interface EmpMapper {
    
	@SelectKey(before = true, keyProperty = "empno", resultType = int.class, statement = { "select emp_seq.nextval from dual" })
	@Insert(value = { "insert into HR.EMP (EMPNO, ENAME, JOB,MGR, HIREDATE, SAL,COMM, DEPTNO) values(#{empno}, #{ename},#{job},#{mgr}, #{hiredate}, #{sal},#{comm}, #{deptno})" })
    public int insert(Emp emp);

	@Insert(value = { "insert into HR.EMP (EMPNO, ENAME, JOB,MGR, HIREDATE, SAL,COMM, DEPTNO) values(#{empno}, #{ename},#{job},#{mgr}, #{hiredate}, #{sal},#{comm}, #{deptno})" })    
    public int insertEmp(Emp emp);
    
    @Delete(value = { "delete from HR.EMP where empno=#{empno}" })
    public int deleteByEmpno(int empno);
    
	@Update(value = { "update HR.EMP set ENAME=#{ename}, JOB=#{job}, MGR=#{mgr}, HIREDATE=#{hiredate},SAL=#{sal}, COMM=#{comm}, DEPTNO=#{deptno} where EMPNO=#{empno}" })
	public int update(Emp emp) throws Exception;
	
	@Select(value = { "select empno,ename from HR.EMP where empno=#{empno}" })
	public Emp selectByEmpno(int empno) throws Exception;
	
	@Select(value = { "select empno,ename from HR.EMP where ename like '%'||#{ename}||'%'" })
	public List<Emp> selectByEname(String ename) throws Exception;
	
	@Select(value = { "select * from HR.EMP where empno=#{empno}" })
	public Emp selectByMap(Map<String,Object> map) throws Exception;
	
	@Select(value = { "select * from HR.EMP" })
	public List<Emp> selectAllEmp() throws Exception;
}