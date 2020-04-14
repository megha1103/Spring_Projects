package com.cg.dao;

import java.util.List;

import com.cg.entity.Emp;

public interface IEmpDao {
	
	boolean addEmp(Emp emp);
	boolean editEmp(Emp emp);
	boolean deleteEmp(int eid);
	Emp viewEmp(int eid);
	List<Emp> viewEmps(String dept);

}
