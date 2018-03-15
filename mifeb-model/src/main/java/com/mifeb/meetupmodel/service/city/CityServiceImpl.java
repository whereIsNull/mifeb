package com.mifeb.meetupmodel.service.city;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mifeb.meetupmodel.dto.city.CityAttendeesDTO;
import com.mifeb.meetupmodel.entity.group.IGroupDao;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CityServiceImpl implements CityService {

	@Autowired
	private IGroupDao groupDao;
	
	@Override
	public List<CityAttendeesDTO> findCitiesOrderByNumAttendees() {
		List<Object[]> citiesByAttendees = groupDao.findCities();
		return citiesByAttendees.stream().map(
				a -> new CityAttendeesDTO(a[0].toString(), ((Long)a[1]).intValue())
			).collect(Collectors.toList());
	}
}
