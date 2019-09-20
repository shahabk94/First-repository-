package com.iconnect.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iconnect.demo.dao.DestinationDAO;
import com.iconnect.demo.domain.Destination;


@Service
public class DestinationServiceImpl implements DestinationService {
	@Autowired
	private DestinationDAO destinationDAO;

//	public void setDestinationDAO(DestinationDAO destinationDAO) {
//	this.destinationDAO = destinationDAO;
//}


	@Override
	@Transactional
	public List<Destination> listDestinations() {
		return destinationDAO.listDestinations();
	}


	

}
