package com.mifeb.meetupmodel.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mifeb.meetupmodel.entity.event.IEventDao;
import com.mifeb.meetupmodel.entity.eventmember.EventMember;
import com.mifeb.meetupmodel.entity.eventmember.IEventMemberDao;
import com.mifeb.meetupmodel.entity.group.IGroupDao;
import com.mifeb.meetupmodel.entity.member.IMemberDao;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class EventServiceImpl implements EventService {

	@Autowired
	private IGroupDao groupDao;
	@Autowired
	private IEventDao eventDao;
	@Autowired
	private IMemberDao memberDao;
	@Autowired
	private IEventMemberDao eventMemberDao;
	
	
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public void setEventDao(IEventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setEventMemberDao(IEventMemberDao eventMemberDao) {
		this.eventMemberDao = eventMemberDao;
	}

	@Override
	public void insertAttendeeToEvent(EventMember eventMember) {
		groupDao.save(eventMember.getEventMemberId().getEvent().getGroup());
		eventDao.save(eventMember.getEventMemberId().getEvent());
		memberDao.save(eventMember.getEventMemberId().getMember());
		eventMemberDao.save(eventMember);
	}
}
