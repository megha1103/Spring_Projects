package com.cg.client;

import java.time.LocalDate;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Emp;

public class PostDemo {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url= "http://localhost:8082/springrest/add";
		Emp emp = new Emp();
		emp.setEmpId(2006);
		emp.setEmpName("nishant");
		emp.setEmpSal(34000);
		emp.getDept().setDeptId(2);
		emp.setDoj(LocalDate.of(2016, 3, 15));
		System.out.println(emp.getDoj());
		try {
		String res =rt.postForObject(url, emp, String.class);
		System.out.println("result " + res);
		}catch(HttpClientErrorException ex) {
			System.out.println(ex.getResponseBodyAsString());
		}
	}

}
