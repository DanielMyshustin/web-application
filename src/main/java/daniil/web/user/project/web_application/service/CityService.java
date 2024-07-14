package daniil.web.user.project.web_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniil.web.user.project.web_application.dao.CityRepository;
import daniil.web.user.project.web_application.model.City;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}
	
	public Optional<City> getCityById(Integer cityId) {
		return cityRepository.findById(cityId);
	}
	
	public City createCity(City city) {
		return cityRepository.save(city);
	}
	
	public City updateCity(Integer cityId, City updatedCity) {
		Optional<City> existingCity = cityRepository.findById(cityId);
		if(existingCity.isPresent()) {
			updatedCity.setId(cityId);
			return cityRepository.save(updatedCity);
		} else {
			return null;
		}
	}
	
	public void deleteCity(Integer cityId) {
		cityRepository.deleteById(cityId);
	}
}

