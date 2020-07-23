package com.mercury.scheduler;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestScheduler {
	
	@Test
	public void stop() {
		try {
			
			URI uri = new URI("http://localhost:9090/service/batch/scheduler");

			RestTemplate rest = new RestTemplate();
			
			ObjectMapper mapper = new ObjectMapper();
			String str = mapper.writeValueAsString("11b9d987bc1a4f7eaa5078b7c8a0272c");

			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

			headers.add("Content-Type", "application/json");

			ResponseEntity<Object> re = rest.exchange(uri, HttpMethod.DELETE, new HttpEntity<Object>(str, headers), Object.class);

			System.out.println(re.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
