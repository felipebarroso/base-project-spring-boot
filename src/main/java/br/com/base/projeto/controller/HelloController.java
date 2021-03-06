package br.com.base.projeto.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('admin', 'hello-get')")
	public String hello() {
		return "Hello World!"; 
	}

}
