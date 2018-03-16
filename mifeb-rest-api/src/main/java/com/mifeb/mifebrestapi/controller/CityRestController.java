package com.mifeb.mifebrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mifeb.meetupmodel.dto.city.CityAttendeesDTO;
import com.mifeb.meetupmodel.service.city.CityService;

@RestController
public class CityRestController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping("/topCities")
    public @ResponseBody List<CityAttendeesDTO> cities() {
        return cityService.findCitiesOrderByNumAttendees();
    }
}
