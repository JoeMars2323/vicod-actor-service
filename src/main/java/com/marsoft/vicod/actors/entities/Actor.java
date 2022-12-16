package com.marsoft.vicod.actors.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id")
	private Long actorId;
	
	@Column(name = "actor_name", nullable = false, unique = true)
	private String actorName;
	
	@Column(name = "actor_birth_name")
	private String actorBirthName;
	
	@Column(name = "actor_nickname")
	private String actorNickName;

	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "height")
	private float height;
	
	@Column(name = "biography")
	private String biography;
	
	

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
	
	

}