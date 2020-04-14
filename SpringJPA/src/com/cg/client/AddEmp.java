package com.cg.client;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;

public class AddEmp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jpaconfig.xml");
		IEmpDao dao = ctx.getBean("mydao", IEmpDao.class);
		Emp emp = new Emp();
		emp.setEmpId(1008);
		emp.setEmpName("Krishana");
		emp.setEmpSal(80500.0);
		emp.setEmpDept("tr");
		emp.setDoj(LocalDate.of(2017, 04, 15));
		
		try {
			dao.addEmp(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Row not added");
		}
		
		
	}

}
