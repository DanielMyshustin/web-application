package daniil.web.user.project.web_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import daniil.web.user.project.web_application.model.City;
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
		model.addAttribute("cities", new City());
		return "cities";
	}
	
	@PostMapping("/cities")
	public String addCity(@ModelAttribute City city) {
	     cityService.createCity(city);
	     return "redirect:/cities";
	}
}


