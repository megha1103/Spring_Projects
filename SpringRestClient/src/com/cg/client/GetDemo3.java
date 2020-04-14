package com.cg.client;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Emp;

public class GetDemo3 {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url= "http://localhost:8082/springrest/viewall";
		
		ResponseEntity<List<Emp>> resp = rt.exchange(url, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Emp>>() {});
		
		List<Emp> lst = resp.getBody();
        lst.forEach(System.out::println);
        
	}

}
