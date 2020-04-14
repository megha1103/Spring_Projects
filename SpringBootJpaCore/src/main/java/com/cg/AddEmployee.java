package com.cg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.IEmpDao;
import com.cg.entity.Dept;
import com.cg.entity.Emp;

//@SpringBootApplication
public class AddEmployee implements CommandLineRunner {

	@Autowired
	private IEmpDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(AddEmployee.class, args);
  
	}

	@Override
	public void run(String... args) throws Exception {
		Emp emp = new Emp();
		emp.setEmpId(2001);
		emp.setEmpName("sunil kumar");
		emp.setEmpSal(35000);
		Dept dept = new Dept();
		dept.setDeptId(1);
		emp.setDept(dept);
		emp.setDoj("2016-11-23");
		dao.addEmp(emp);
		System.out.println("employee added");
		dao.viewEmp().forEach(System.out::println);
		
	}

}







