package com.shahab.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shahab.spring.model.Destination;
import com.shahab.spring.service.DestinationService;


@RestController
public class DestinationRestController {
	
	private DestinationService destinationService;
	 Destination destination;
	@Autowired(required=true)
	@Qualifier(value="destinationService")
	public void setDestinationService(DestinationService ds){
		this.destinationService = ds;
	}
	
	 @PostConstruct
	    private void postConstruct() {
		 
		 destination = new Destination("Washington", "1234 independent road, washington, 12345","DC");
	        
	    }
	 
	@RequestMapping(value = "/destination", method = RequestMethod.GET,produces= {"application/json","application/xml"})
	
	public Destination listDestinations() {
		return destination;
	}
	
	
@RequestMapping(value = "/allDestinationList", method = RequestMethod.GET,produces= {"application/json","application/xml"})
	
	public List<Destination> allDestinationsList() {
		List<Destination> destinationList = new ArrayList<Destination>();
		destinationList = destinationService.listAll();
		destinationList.add(destination);
		return destinationList;
	}
}
