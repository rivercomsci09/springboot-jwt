package com.river.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String firstPage() {
		return "Hello world";
	}
}
