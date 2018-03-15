package com.mifeb.meetupmodel.dto.group;

public class GroupDistanceDTO {

	private Long groupId;
	private String groupName;
	private String city;
	private Double distanceToRequestPoint;
	private Double requestedLat;
	private Double requestedLon;
	
	public GroupDistanceDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupDistanceDTO(Long groupId, String groupName, String city, Double distanceToRequestPoint,
			Double requestedLat, Double requestedLon) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.city = city;
		this.distanceToRequestPoint = distanceToRequestPoint;
		this.requestedLat = requestedLat;
		this.requestedLon = requestedLon;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getDistanceToRequestPoint() {
		return distanceToRequestPoint;
	}

	public void setDistanceToRequestPoint(Double distanceToRequestPoint) {
		this.distanceToRequestPoint = distanceToRequestPoint;
	}

	public Double getRequestedLat() {
		return requestedLat;
	}

	public void setRequestedLat(Double requestedLat) {
		this.requestedLat = requestedLat;
	}

	public Double getRequestedLon() {
		return requestedLon;
	}

	public void setRequestedLon(Double requestedLon) {
		this.requestedLon = requestedLon;
	}
}
