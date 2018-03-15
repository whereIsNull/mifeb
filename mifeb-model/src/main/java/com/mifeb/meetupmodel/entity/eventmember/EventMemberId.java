package com.mifeb.meetupmodel.entity.eventmember;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.mifeb.meetupmodel.entity.event.Event;
import com.mifeb.meetupmodel.entity.member.Member;

@Embeddable
public class EventMemberId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4460337335498844783L;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Event event;
	
	public EventMemberId() {
		// TODO Auto-generated constructor stub
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventMemberId other = (EventMemberId) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		return true;
	}
	
}
