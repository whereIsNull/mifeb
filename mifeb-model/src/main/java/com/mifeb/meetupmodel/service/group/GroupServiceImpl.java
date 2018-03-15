package com.mifeb.meetupmodel.service.group;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mifeb.meetupmodel.dto.group.GroupDistanceDTO;
import com.mifeb.meetupmodel.entity.group.Group;
import com.mifeb.meetupmodel.entity.group.IGroupDao;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private IGroupDao groupDao;
	
	@Override
	public List<GroupDistanceDTO> findGroupsOrderByDistance(Double lat, Double lon) {
		List<Group> groups = groupDao.findAll();
		List<GroupDistanceDTO> groupsDistance = groups.stream().map(a -> {
			GroupDistanceDTO dto = new GroupDistanceDTO();
			dto.setGroupId(a.getGroupId());
			dto.setGroupName(a.getGroupName());
			dto.setCity(a.getCity());
			dto.setRequestedLat(lat);
			dto.setRequestedLon(lon);
			BigDecimal requestedLat = new BigDecimal(lat);
			BigDecimal requestedLon = new BigDecimal(lon);
			BigDecimal groupLat = new BigDecimal(a.getLat());
			BigDecimal groupLon = new BigDecimal(a.getLon());
			BigDecimal sqrDif = requestedLat.subtract(groupLat).pow(2).add((requestedLon.subtract(groupLon)).pow(2));
			dto.setDistanceToRequestPoint(Math.sqrt(sqrDif.doubleValue()));
			return dto;
		}).collect(Collectors.toList());
		groupsDistance.sort((a, b)->a.getDistanceToRequestPoint().compareTo(b.getDistanceToRequestPoint()));
		return groupsDistance;
	}

}
