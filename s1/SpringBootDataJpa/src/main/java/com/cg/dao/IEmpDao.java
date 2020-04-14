package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Dept;
import com.cg.entity.Emp;
@Repository
public interface IEmpDao extends JpaRepository<Emp, Integer> {
	
	@Query("from Emp e inner join fetch e.dept d where d.deptName=:dname")
	List<Emp> viewEmp(@Param("dname") String dept);
	
	@Query("from Emp e inner join fetch e.dept d")
	List<Emp> viewEmp();
}
