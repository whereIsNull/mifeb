package com.mifeb.meetupmodel.service.group;

import java.util.List;

import com.mifeb.meetupmodel.dto.group.GroupDistanceDTO;

public interface GroupService {

	public List<GroupDistanceDTO> findGroupsOrderByDistance(Double lat, Double lon);
}
