package com.mifeb.meetupmodel.entity.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGroupDao extends JpaRepository<Group, Integer> {

	@Query("select g.city, count(em) as attendees "
			+ "from EventMember em "
			+ "inner join em.eventMemberId.event e "
			+ "inner join em.eventMemberId.event.group g "
			+ "where e.time >= :startDay and e.time < :endDay "
			+ "group by g.city "
			+ "order by count(em) desc")
	public List<Object[]> findCities(@Param("startDay") Long startDay, @Param("endDay") Long endDay);
}
