package com.mifeb.meetupmodel.dto.city;

public class CityAttendeesDTO {

	private String city;
	private int attendees;
	
	public CityAttendeesDTO() {
		// TODO Auto-generated constructor stub
	}	
	
	public CityAttendeesDTO(String city, int attendees) {
		super();
		this.city = city;
		this.attendees = attendees;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAttendees() {
		return attendees;
	}

	public void setAttendees(int attendees) {
		this.attendees = attendees;
	}
	
	
}
