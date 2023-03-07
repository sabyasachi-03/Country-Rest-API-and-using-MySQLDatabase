package com.countryservice.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryrep;
	
	
	//Get all Country 
	public List<Country> getAllCountries()
	{
		return countryrep.findAll();	
	}
	
	//get country by id
	public Country getCountrybyId(int id)
	{
		return countryrep.findById(id).get();
	}
	
	//post/create
	public Country addCountry(Country country)
	{
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
	}
	
	public int getMaxId()
	{
		return countryrep.findAll().size()+1;
	}
	
	
	//update
	public Country updateCountry(Country country)
	{
		countryrep.save(country);
		return country;
	}
	
	//Delete
	public AddResponse deleteCountry(int id)
	{
		countryrep.deleteById(id);
		AddResponse res=new AddResponse();
		res.setMsg("Country deleted");
		res.setId(id);
		return res;
	}
	
	
}
