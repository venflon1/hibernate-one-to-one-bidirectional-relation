package com.roberto.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This is a Java POJO - A normal class with a bit of java annotation
 * 
 * */
@Entity		
@Table(name = "instructor_detail")
public class InstructorDetail implements Cloneable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")	 
	private long identifier;
	
	@Column(name = "youtube_channel")
	private String nameYoutubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail",  cascade = CascadeType.REMOVE)
	private Instructor instructor;
	
	public InstructorDetail(String nameYoutubeChannel, String hobby) {
		super();
		this.nameYoutubeChannel = nameYoutubeChannel;
		this.hobby = hobby;
	}
	
	public InstructorDetail() {
		this(null, null);
	}

	public long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public String getNameYoutubeChannel() {
		return nameYoutubeChannel;
	}

	public void setNameYoutubeChannel(String nameYoutubeChannel) {
		this.nameYoutubeChannel = nameYoutubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstructorDetail [identifier=");
		builder.append(identifier);
		builder.append(", nameYoutubeChannel=");
		builder.append(nameYoutubeChannel);
		builder.append(", hobby=");
		builder.append(hobby);
		builder.append("]");
		return builder.toString();
	}
}
