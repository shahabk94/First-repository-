package net.shahab.spring.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "destination")
@XmlAccessorType(XmlAccessType.NONE)
public class Destination {

	@XmlAttribute
	private String name;
	@XmlElement
	private String adress;
	@XmlElement
	private String state;
	


    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
  
	public Destination(String name, String adress, String state) {
		
		this.name = name;
		this.adress = adress;
		this.state = state;
		
	}

	public Destination() {
	}

	//..Getter and setter methods

}