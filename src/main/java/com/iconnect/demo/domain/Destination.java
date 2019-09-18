package com.iconnect.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "destination")
@Entity
@Table(name="destination")
public class Destination {
	
	@Id
	@Column(name="destination_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@XmlElement
	String destination_name;
	
	 @XmlElement
	String address;
	 
	 @XmlElement
	String state;
	
	
	public String getDestination_name() {
		return destination_name;
	}
	public void setDestination_name(String destination_name) {
		this.destination_name = destination_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Destination(String destination_name, String address, String state) {
		super();
		this.destination_name = destination_name;
		this.address = address;
		this.state = state;
	}
	
	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
