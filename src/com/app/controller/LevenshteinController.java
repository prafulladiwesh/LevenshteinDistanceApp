package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.LevenshteinDistance;

/**
 * 
 * @author Prafulla Diwesh(prafulladiwesh@gmail.com)
 *
 */
@Controller
public class LevenshteinController {
	
	@Autowired
	LevenshteinDistance levenshteinDistance;

	@RequestMapping("/home")
	public ModelAndView uploadHome() {
		return new ModelAndView("home", "string", new String());
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String calculateDistance(@RequestParam("token1") String token1,
			@RequestParam("token2") String token2, ModelMap modelMap) {
		try {
			int distance = levenshteinDistance.levenshtein(token1, token2);
			modelMap.addAttribute("message", distance);
			modelMap.addAttribute("text1", token1);
			modelMap.addAttribute("text2", token2);
		} catch (Exception e) {
			modelMap.addAttribute("message", e.getMessage());
		}
		return "home";
	}

}
