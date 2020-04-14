package com.cg.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Emp;

public class PutDemo {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url= "http://localhost:8082/springrest/viewbyid/1002";
		Emp emp = rt.getForObject(url, Emp.class);
		emp.setEmpSal(41000);
		String url2= "http://localhost:8082/springrest/edit";
		HttpEntity<Emp> req = new HttpEntity<>(emp);
		ResponseEntity<String> resp =rt.exchange(url2, HttpMethod.PUT, req, String.class);
		System.out.println(resp.getBody());
	}

}
