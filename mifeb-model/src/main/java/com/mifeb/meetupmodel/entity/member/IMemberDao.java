package com.mifeb.meetupmodel.entity.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberDao extends JpaRepository<Member, Long> {

}
