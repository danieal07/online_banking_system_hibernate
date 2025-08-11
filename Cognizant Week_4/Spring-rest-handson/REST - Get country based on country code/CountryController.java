package com.cognizant.countrycodeservice.controller;

import com.cognizant.countrycodeservice.model.Country;
import com.cognizant.countrycodeservice.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry() for code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry()");
        return country;
    }
}
