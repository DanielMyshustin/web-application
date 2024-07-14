package daniil.web.user.project.web_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import daniil.web.user.project.web_application.service.CityService;

@Controller
public class CityController {
	
	private final CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public String showCities(Model model) {
		model.addAttribute("cities", cityService.getAllCities());
		return "cities";
	}
}

