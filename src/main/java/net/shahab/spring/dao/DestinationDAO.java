package net.shahab.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.shahab.spring.model.Destination;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="destination")

@Component
public class DestinationDAO {

	
	private static List<Destination> Dest;
	{
		Dest = new ArrayList<Destination>();
		Dest.add(new Destination("Washington", "1234 independent road, washington, 12345", "DC"));
		Dest.add(new Destination("Vancouver", "South Canada", "British Columbia"));
	}

	
	public List<Destination> list() {
		return Dest;
	}

	
	

}