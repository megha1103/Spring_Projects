package com.cg.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class DeleteDemo {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url= "http://localhost:8082/springrest/remove/2004";
		ResponseEntity<String> resp =rt.exchange(url, HttpMethod.DELETE, null, String.class);
		String result =resp.getBody();
		System.out.println(result);
		
	}

}
