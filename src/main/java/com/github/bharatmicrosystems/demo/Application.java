package com.github.bharatmicrosystems.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {
	public static String uri;
	@RequestMapping("/**")
	public String callBackend(HttpServletRequest request) {
		
	    String serverName = request.getServerName();
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return serverName+" -> "+result;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		uri = args[0];
	}

}
