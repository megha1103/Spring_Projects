package com.cg.client;

import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.cg.entity.Emp;

public class GetDemo2 {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		String url= "http://localhost:8082/springrest/viewall";
		List<Map<String, Object>> lst= rt.getForObject(url, List.class);
		for(Map<String, Object> map:lst) {
			System.out.println(map.get("empId"));
			System.out.println(map.get("empName"));
			System.out.println(map.get("empSal"));
			System.out.println(((Map)map.get("dept")).get("deptName"));
			System.out.println(map.get("doj"));
			System.out.println("--------------------------------------");
			
		}
		

	}

}
