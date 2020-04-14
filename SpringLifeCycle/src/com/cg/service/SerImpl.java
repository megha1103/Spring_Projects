package com.cg.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SerImpl implements IService, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
      InitializingBean, DisposableBean{

	private String msg;
	
	public SerImpl() {
		System.out.println("Service constructor");
	}
	//seteer is used by IOC to injecer
	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("Injected msg");
	}

	@Override
	public String sayHello(String str) {
		return msg + " " + str;
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("application context aware");
	}
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("bean factory aware");
		
	}
	@Override
	public void setBeanName(String bean) {
		System.out.println("bean name aware " + bean);
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy -- Disposable");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init -- after properies set");
		
	}

	public void myInit() {
		System.out.println("custom Init");
	}
	
	public void myDestroy() {
		System.out.println("custom Destory");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("post construct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("pre destroy");
	}
	
}







