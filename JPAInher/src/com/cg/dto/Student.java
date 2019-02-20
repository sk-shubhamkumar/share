package com.cg.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rollNo", length = 10)
	private int rollNo;

	@Column(name = "stu_name", length = 25)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address stuAddress;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(Address stuAddress) {
		this.stuAddress = stuAddress;
	}

	public Student() {
		super();
	}

	public Student(int rollNo, String name, Address stuAddress) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.stuAddress = stuAddress;
	}

}
