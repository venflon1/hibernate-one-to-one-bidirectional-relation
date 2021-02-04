package com.roberto.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This is a Java POJO - A normal class with a bit of java annotation
 * 
 * */
@Entity		
@Table(name = "instructor")
public class Instructor implements Cloneable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")	 
	private long identifier;
	
	@Column(name = "first_name")
	private String name;
	
	@Column(name = "last_name")
	private String surname;
			
	@Column(name = "email")
	private String emailAddress;
	
	@OneToOne(cascade = CascadeType.ALL)	// relation 1-1 with Entity InstructorDetail
	@JoinColumn(name = "instructor_detail_id")	// This is a column for foreign_key in instructor table
	private InstructorDetail instructorDetail;
	
	public Instructor(String name, String surname, String emailAddress, InstructorDetail instructorDetail) {
		super();
		this.name = name;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.instructorDetail = instructorDetail;
	}
	
	public Instructor() {
		this("default-name", "default-surname", "default@email.com", null);
	}

	public long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HbStudent [identifier=");
		builder.append(identifier);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}

}
