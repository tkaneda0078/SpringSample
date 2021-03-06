package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	private Map<String, String> radioMarriage;

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home::home_contents");

		return "login/homeLayout";
	}

	@GetMapping("/userList")
	public String getUserList(Model model) {
		model.addAttribute("contents", "login/userList::userList_contents");

		List<User> userList = userService.getAll();

		model.addAttribute("userList", userList);

		int count = userService.count();

		model.addAttribute("userListCount", count);

		return "login/homeLayout";
	}

	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form, Model model, @PathVariable("id") String userId) {
		model.addAttribute("contents", "login/userDetail::userDetail_contents");

		radioMarriage = initRadioMarriage();
		model.addAttribute("radioMarriage", radioMarriage);

		if (userId != null && userId.length() > 0) {
			User user = userService.getOne(userId);
			form.setUserId(user.getUserId());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			form.setMarriage(user.isMarriage());

			model.addAttribute("signupForm", form);
		}

		return "login/homeLayout";
	}

	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {
		return getUserList(model);
	}

	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}

	private Map<String, String> initRadioMarriage() {
		Map<String, String> radioMap = new LinkedHashMap<>();

		radioMap.put("既婚", "true");
		radioMap.put("未婚", "false");

		return radioMap;
	}
}
