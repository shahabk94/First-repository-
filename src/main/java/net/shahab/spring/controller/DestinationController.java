
package net.shahab.spring.controller;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shahab.spring.dao.DestinationDAO;
import net.shahab.spring.model.Destination;

@RestController
public class DestinationController {

	
	@Autowired
	private DestinationDAO destDAO;

	@PostConstruct
	@GetMapping(path="/destination", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Destination> getDestinations() {
		return destDAO.list();
	}

	
}