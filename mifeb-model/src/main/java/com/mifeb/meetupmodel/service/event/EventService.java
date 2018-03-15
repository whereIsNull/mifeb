package com.mifeb.meetupmodel.service.event;

import com.mifeb.meetupmodel.entity.eventmember.EventMember;

public interface EventService {

	public void insertAttendeeToEvent(EventMember eventMember);
}
