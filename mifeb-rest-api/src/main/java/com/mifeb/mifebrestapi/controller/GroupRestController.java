package com.mifeb.mifebrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mifeb.meetupmodel.dto.group.GroupDistanceDTO;
import com.mifeb.meetupmodel.service.group.GroupService;

@RestController
public class GroupRestController {

	@Autowired
	private GroupService groupService;
	
	@RequestMapping("/groups")
    public @ResponseBody List<GroupDistanceDTO> groups(@RequestParam(value="lat") Double lat, @RequestParam(value="long") Double lon) {
        return groupService.findGroupsOrderByDistance(lat, lon);
    }
}
