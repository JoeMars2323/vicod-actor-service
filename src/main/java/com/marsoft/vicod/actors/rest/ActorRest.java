package com.marsoft.vicod.actors.rest;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {
	
	private static final long serialVersionUID = 6228857373313779446L;

	private Long actorId;
	private String actorName;
	private String actorBirthName;
	private String actorNickName;
	private String country;
	private String city;
	private Date birthday;
	private float height;
	private String biography;
	
	private String brockerId;
	private EventType eventType;
	
	
	
	public ActorRest(String actorName, String actorBirthName, String country, Date birthday) {
		this.actorName = actorName;
		this.actorBirthName = actorBirthName;
		this.country = country;
		this.birthday = birthday;
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorBirthName() {
		return actorBirthName;
	}

	public void setActorBirthName(String actorBirthName) {
		this.actorBirthName = actorBirthName;
	}

	public String getActorNickName() {
		return actorNickName;
	}

	public void setActorNickName(String actorNickName) {
		this.actorNickName = actorNickName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getBrockerId() {
		return brockerId;
	}

	public void setBrockerId(String brockerId) {
		this.brockerId = brockerId;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}



	@Override
	public String toString() {
		return "ActorRest [actorName=" + actorName + ", actorBirthName=" + actorBirthName + ", actorNickName="
				+ actorNickName + ", country=" + country + ", city=" + city + ", birthday=" + birthday + ", height="
				+ height + ", biography=" + biography + "]";
	}
	
	
	
}