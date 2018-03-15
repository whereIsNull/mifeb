package com.mifeb.meetupmodel.entity.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGroupDao extends JpaRepository<Group, Integer> {

	@Query("select g.city, count(em) as attendees "
			+ "from EventMember em "
			+ "inner join em.eventMemberId.event.group g "
			+ "group by g.city "
			+ "order by count(em) desc")
	public List<Object[]> findCities();
}
