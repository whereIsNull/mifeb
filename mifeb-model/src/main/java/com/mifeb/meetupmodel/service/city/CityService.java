package com.mifeb.meetupmodel.service.city;

import java.util.List;

import com.mifeb.meetupmodel.dto.city.CityAttendeesDTO;

public interface CityService {

	List<CityAttendeesDTO> findCitiesOrderByNumAttendees(String isoTime);

}
