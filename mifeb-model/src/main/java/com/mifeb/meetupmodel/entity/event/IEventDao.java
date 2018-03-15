package com.mifeb.meetupmodel.entity.event;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IEventDao extends JpaRepository<Event, String> {

}
