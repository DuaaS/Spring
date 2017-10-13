package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.CountriesDao;
import com.giced.model.Countries;

@Service
@Component
public class CountriesServiceImpl implements CountriesService {
	
	@Autowired
	private CountriesDao countryDao;

	@Autowired
	public CountriesDao getCountryDao() {
		return countryDao;
	}
	
	@Autowired
	public void setCountryDao(CountriesDao countryDao) {
		this.countryDao = countryDao;
	}
	
	
    @Override
    @Transactional
	public List<Countries> getAllCountries() {
		return countryDao.getAllCountries();
	}
    
    @Override
    @Transactional
	public Countries getCountry(int id) {
		return countryDao.getCountry(id);
	}
	
	

}
