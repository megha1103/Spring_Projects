package com.cg.client;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Emp;

public class GetDemo1 {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8082/springrest/viewbyid/1001";
		try {
			Emp emp = rt.getForObject(url, Emp.class);
			System.out.println(emp);
		} catch (HttpClientErrorException ex) {
			System.out.println(ex.getResponseBodyAsString());
		}

	}

}
