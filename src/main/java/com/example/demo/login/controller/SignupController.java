package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
	private Map<String, String> radioMarriage;

	@GetMapping("/signup")
	public String getSignUp(Model model) {
		radioMarriage = initRadioMarriage();

		model.addAttribute("radioMarriage", radioMarriage);

		return "login/signup";
	}

	@PostMapping("/signup")
	public String postSignUp(Model model) {
		return "redirect:/login";
	}

	private Map<String, String> initRadioMarriage() {
		Map<String, String> radioMap = new LinkedHashMap<>();

		radioMap.put("既婚", "true");
		radioMap.put("未婚", "false");

		return radioMap;
	}
}
