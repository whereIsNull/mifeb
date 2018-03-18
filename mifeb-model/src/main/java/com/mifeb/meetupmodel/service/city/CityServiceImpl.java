package com.mifeb.meetupmodel.service.city;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
	public List<CityAttendeesDTO> findCitiesOrderByNumAttendees(String isoTime) {
		Long time = Instant.parse(isoTime).toEpochMilli();
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(time);
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		Long startDay = date.getTimeInMillis();
		date.add(Calendar.DAY_OF_MONTH, 1);
		Long endDay = date.getTimeInMillis();
		List<Object[]> citiesByAttendees = groupDao.findCities(startDay, endDay);
		return citiesByAttendees.stream().map(
				a -> new CityAttendeesDTO(a[0].toString(), ((Long)a[1]).intValue())
			).collect(Collectors.toList());
	}
}
