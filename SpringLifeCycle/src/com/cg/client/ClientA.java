package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.service.IService;
import com.cg.service.SerImpl;

public class ClientA {

	static AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		
		System.out.println("main_start");
		IService service1 = ctx.getBean(SerImpl.class);
		System.out.println(service1.sayHello(" Rahhi Barbool"));
		IService service2 = ctx.getBean(SerImpl.class);
		System.out.println(service2.sayHello(" Pritam Patel"));
		ctx.registerShutdownHook();
		
		
	}

}
