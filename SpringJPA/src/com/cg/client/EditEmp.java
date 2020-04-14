package com.cg.client;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;

public class EditEmp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jpaconfig.xml");
		IEmpDao dao = ctx.getBean("mydao", IEmpDao.class);
		Emp emp = dao.viewEmp(1002);
		System.out.println("-------------------------------");
		emp.setEmpDept("tr");
		System.out.println("-------------------------------");
		dao.editEmp(emp);

	}

}
