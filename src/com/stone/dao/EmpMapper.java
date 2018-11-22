package com.stone.dao;

import java.util.List;
import java.util.Map;

import com.stone.entity.Emp;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.EMP
     *
     * @mbg.generated Tue Nov 20 11:31:24 CST 2018
     */
    public int insert(Emp emp);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.EMP
     *
     * @mbg.generated Tue Nov 20 11:31:24 CST 2018
     */
    public int insertSelective(Emp emp);
    
    /**
     * 单纯插入，编号不由序列产生
     * @param emp
     * @return
     */
    public int insertEmp(Emp emp);
    
    /**
     * 根据empno删除记录，1次删除1条
     * @param empno 要删除雇员的编号
     * @return 返回删除的行数
     */
    public int deleteByEmpno(int empno);
    
	/**
	 * 执行数据的更新操作
	 * @param emp 包含了新数据的VO对象
	 * @return 返回更新的行数
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public int update(Emp emp) throws Exception;
	
	/**
	 * 根据雇员编号查询一个雇员的完整信息
	 * @param empno 要查询的雇员编号
	 * @return 如果没有指定雇员的编号，返回值为null，如果有指定雇员编号，则将雇员信息包装到Emp实例化对象中返回
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public Emp selectByEmpno(int empno) throws Exception;
	
	/**
	 * 
	 * @param ename
	 * @return
	 * @throws Exception
	 */
	public List<Emp> selectByEname(String ename) throws Exception;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Emp selectByMap(Map<String,Object> map) throws Exception;
	
	/**
	 * 查询全部的雇员信息
	 * @return 多个雇员信息使用List返回，如果List集合的size()长度为0，则表示没有数据返回
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public List<Emp> selectAllEmp() throws Exception;
	
	/**
	 * 查询全部的雇员信息
	 * @return 雇员信息使用Map返回
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public Map<String,Emp> selectEmpMap() throws Exception;
	
	/**
	 * 分页显示所有雇员的信息，同时可以完成模糊查询
	 * @param column 要模糊查询的字段名称
	 * @param keyWord 要模糊查询的数据，如果为空字符串（isEmpty()判断为true，表示空字符串），则表示查询全部
	 * @param currentPage 读取所在的页
	 * @param lineSize 每页显示的记录条数
	 * @return 多个雇员信息使用List返回，如果List集合的size()长度为0，则表示没有数据返回
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public List<Emp> findAll(String column,String keyWord,int currentPage,int lineSize) throws Exception;
	
	/**
	 * 统计模糊查询的数据结果，使用COUNT()函数进行统计
	 * @param column 要模糊查询的字段名称
	 * @param keyWord 要模糊查询的数据，如果为空字符串（isEmpty()判断为true，表示空字符串），则表示查询全部
	 * @return 会根据数据量的多少返回数据的长度，如果没有数据返回0
	 * @throws Exception 操作中出现了异常，返回给被调用处执行处理
	 */
	public int getAllCount(String column,String keyWord) throws Exception;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Emp> selectEmpByMap(Map<String,Object> map) throws Exception;
	
	/**
	 * 
	 * @param ename
	 * @param sal
	 * @return
	 * @throws Exception
	 */
	public List<Emp> selectEmpByConditions(String ename,double sal) throws Exception;
	
	/**
	 * 
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	public List<Emp> selectEmpIf(Emp emp) throws Exception;
	
	/**
	 * 
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	public List<Emp> selectEmpWhere(Emp emp) throws Exception;
}