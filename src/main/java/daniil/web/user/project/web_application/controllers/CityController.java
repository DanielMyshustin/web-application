package daniil.web.user.project.web_application.controllers;

import java.util.List;

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
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/cities")
	public String getAllCities(Model model) {
		List<City> cities = cityService.getAllCities();
		model.addAttribute("cities", cities);
		return "cities";
	}
	
	@GetMapping("/cities/new")
	public String showNewCityForm(Model model) {
		City city = new City();
		model.addAttribute("city", city);
		return "city_form";
	}
	
	@PostMapping("/cities/new")
	public String saveCity(@ModelAttribute("city") City city) {
		cityService.createCity(city);
		return "redirect:/cities";
	}
}


