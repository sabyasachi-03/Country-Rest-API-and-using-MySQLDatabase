package com.countryservice.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.countryservice.demo.beans.Country;

public interface CountryRepository  extends JpaRepository<Country, Integer>{

}
