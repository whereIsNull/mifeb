package com.mifeb.meetupmodel.service.city;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.mifeb.meetupmodel.App;
import com.mifeb.meetupmodel.dto.city.CityAttendeesDTO;
import com.mifeb.meetupmodel.entity.event.Event;
import com.mifeb.meetupmodel.entity.event.IEventDao;
import com.mifeb.meetupmodel.entity.eventmember.EventMember;
import com.mifeb.meetupmodel.entity.eventmember.EventMemberId;
import com.mifeb.meetupmodel.entity.eventmember.IEventMemberDao;
import com.mifeb.meetupmodel.entity.group.Group;
import com.mifeb.meetupmodel.entity.group.IGroupDao;
import com.mifeb.meetupmodel.entity.member.IMemberDao;
import com.mifeb.meetupmodel.entity.member.Member;
import com.mifeb.meetupmodel.service.city.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CityServiceImplTest {

	@Autowired
	private IGroupDao groupDao;
	
	@Autowired
	private IEventDao eventDao;
	
	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IEventMemberDao eventMemberDao;
	
	@Autowired
	private CityService cityService;
	
	@Before
	public void setUp() {
		Group group1 = new Group();
		group1.setGroupId(1L);
		group1.setGroupName("Group-1");
		group1.setCity("Naron");
		group1.setLat(Float.valueOf("9.05"));
		group1.setLon(Float.valueOf("9.15"));
		Group group2 = new Group();
		group2.setGroupId(2L);
		group2.setGroupName("Group-2");
		group2.setCity("Ferrol");
		group2.setLat(Float.valueOf("8.55"));
		group2.setLon(Float.valueOf("8.75"));
		Group group3 = new Group();
		group3.setGroupId(3L);
		group3.setGroupName("Group-3");
		group3.setCity("Santiago");
		group3.setLat(Float.valueOf("2.55"));
		group3.setLon(Float.valueOf("3.75"));
		
		groupDao.save(group1);
		groupDao.save(group2);
		groupDao.save(group3);
		
		for(int i=1; i<=10; i++) {
			Member p = new Member();
			p.setMemberId(Long.valueOf(i));
			p.setMemberName("person"+i);
			memberDao.save(p);
		}
		
		Event event = new Event();
		event.setEventId("event_1.1");
		event.setEventName("Event group 1_1");
		event.setGroup(group1);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		List<Member> members = memberDao.findAllById(Arrays.asList(new Long[] {1L, 4L, 7L, 8L, 9L, 10L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}	
		
		event = new Event();
		event.setEventId("event_1.2");
		event.setEventName("Event group 1_2");
		event.setGroup(group1);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {5L, 6L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
		event = new Event();
		event.setEventId("event_2.1");
		event.setEventName("Event group 2_1");
		event.setGroup(group2);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {1L, 2L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
		event = new Event();
		event.setEventId("event_2.2");
		event.setEventName("Event group 2_2");
		event.setGroup(group2);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {5L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
		event = new Event();
		event.setEventId("event_3.1");
		event.setEventName("Event group 3_1");
		event.setGroup(group3);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {1L, 2L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
		event = new Event();
		event.setEventId("event_3.2");
		event.setEventName("Event group 3_2");
		event.setGroup(group3);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {7L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
		event = new Event();
		event.setEventId("event_3.3");
		event.setEventName("Event group 3_3");
		event.setGroup(group3);
		event.setTime(Calendar.getInstance().getTimeInMillis());
		eventDao.save(event);
		members = memberDao.findAllById(Arrays.asList(new Long[] {5L}));
		for(Member member: members) {
			EventMember eventMember = new EventMember();
			EventMemberId eventMemberId = new EventMemberId();
			eventMemberId.setEvent(event);
			eventMemberId.setMember(member);
			eventMember.setEventMemberId(eventMemberId);
			eventMemberDao.save(eventMember);
		}
		
	}
	
	@Test
	public void test() {
		List<CityAttendeesDTO> cities = cityService.findCitiesOrderByNumAttendees(Calendar.getInstance().getTimeInMillis());
		
		assertEquals(cities.size(), 3);
		assertEquals(cities.get(0).getCity(), "Naron");
		assertEquals(cities.get(0).getAttendees(), 8L);
		assertEquals(cities.get(1).getCity(), "Santiago");
		assertEquals(cities.get(1).getAttendees(), 4L);
		assertEquals(cities.get(2).getCity(), "Ferrol");
		assertEquals(cities.get(2).getAttendees(), 3L);
		
		Optional<Event> event = eventDao.findById("event_2.1");
		if(event.isPresent()) {
			List<Member> members = memberDao.findAllById(Arrays.asList(new Long[] {5L, 6L}));
			for(Member member: members) {
				EventMember eventMember = new EventMember();
				EventMemberId eventMemberId = new EventMemberId();
				eventMemberId.setEvent(event.get());
				eventMemberId.setMember(member);
				eventMember.setEventMemberId(eventMemberId);
				eventMemberDao.save(eventMember);
			}
		}
				
		cities = cityService.findCitiesOrderByNumAttendees(Calendar.getInstance().getTimeInMillis());
		
		assertEquals(cities.size(), 3);
		assertEquals(cities.get(0).getCity(), "Naron");
		assertEquals(cities.get(0).getAttendees(), 8L);
		assertEquals(cities.get(1).getCity(), "Ferrol");
		assertEquals(cities.get(1).getAttendees(), 5L);
		assertEquals(cities.get(2).getCity(), "Santiago");
		assertEquals(cities.get(2).getAttendees(), 4L);
	}

}
