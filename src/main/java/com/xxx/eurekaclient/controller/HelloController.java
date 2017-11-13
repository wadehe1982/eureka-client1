package com.xxx.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


//import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
	
	@Autowired
	private Registration registration;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String index() {
		
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println(instance);
		
		String serviceId = registration.getServiceId();
		
		log.info("serviceId is: {}", serviceId);
		
		log.info("host is: {}, serviceId: {}, Uri: {}", instance.getHost(), instance.getServiceId(), instance.getUri());
		return "hello";
	}

}
