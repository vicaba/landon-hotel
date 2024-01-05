package com.vicaba.landonhotel.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getWelcome(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return "Hello " + name + "!";
	}

}
