package com.giced.dao;

import java.util.List;

import com.giced.model.Countries;

public interface CountriesDao {
	List<Countries> getAllCountries();
	
	Countries getCountry(int id);

}
