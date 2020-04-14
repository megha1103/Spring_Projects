package com.cg.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("jdbcdao")
@Lazy(true)
public class JdbcDaoImpl implements IDao {
	
	public JdbcDaoImpl() {
		System.out.println("JDBC Dao Constructor");
	}

	@Override
	public String getName() {
		return "jdbc name";
	}

}
