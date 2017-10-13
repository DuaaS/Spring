package com.giced.service;

import java.util.List;

import com.giced.model.Countries;



public interface CountriesService {

	List<Countries> getAllCountries();
	
	Countries getCountry(int id);
}
