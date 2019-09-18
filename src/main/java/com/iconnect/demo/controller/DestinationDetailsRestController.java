package com.iconnect.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iconnect.demo.domain.Destination;
import com.iconnect.demo.service.DestinationService;


@RestController
public class DestinationDetailsRestController {
	
	private DestinationService destinationService;
	 Destination destination;
	@Autowired(required=true)
	@Qualifier(value="destinationService")
	public void setDestinationService(DestinationService ds){
		this.destinationService = ds;
	}
	
	 @PostConstruct
	    private void postConstruct() {
		 System.out.println("---Initialization start---");
		 destination = new Destination("Washington", "1234 independent road, washington, 12345","DC");
	        
	    }
	 
	@RequestMapping(value = "/destination", method = RequestMethod.GET,produces= {"application/json","application/xml"})
	
	public  @ResponseBody Destination listDestinations() {
		return destination;
	}
	
	
@RequestMapping(value = "/allDestinationList", method = RequestMethod.GET,produces= {"application/json","application/xml"})
	
	public  @ResponseBody List<Destination> allDestinationsList() {
		List<Destination> destinationList = new ArrayList<Destination>();
		destinationList = destinationService.listDestinations();
		destinationList.add(destination);
		return destinationList;
	}
}
