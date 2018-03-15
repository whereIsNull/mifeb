package com.mifeb.meetupmodel.entity.eventmember;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EventMember implements Serializable {

	private static final long serialVersionUID = -1763070811394169475L;

	@EmbeddedId
	private EventMemberId eventMemberId;
	private Long inscriptionTime;
	
	public EventMember() {
		// TODO Auto-generated constructor stub
	}

	public EventMemberId getEventMemberId() {
		return eventMemberId;
	}
	
	public void setEventMemberId(EventMemberId eventMemberId) {
		this.eventMemberId = eventMemberId;
	}
	
	public Long getInscriptionTime() {
		return inscriptionTime;
	}
	
	public void setInscriptionTime(Long inscriptionTime) {
		this.inscriptionTime = inscriptionTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventMemberId == null) ? 0 : eventMemberId.hashCode());
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
		EventMember other = (EventMember) obj;
		if (eventMemberId == null) {
			if (other.eventMemberId != null)
				return false;
		} else if (!eventMemberId.equals(other.eventMemberId))
			return false;
		return true;
	}
	
}
