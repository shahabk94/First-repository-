package com.shahab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shahab.spring.dao.DestinationDao;
import com.shahab.spring.model.Destination;


public class DestinationService {
	private DestinationDao destinationDao;

	public void setDestinationDao(DestinationDao destinationDao) {
	this.destinationDao = destinationDao;
}


	@Transactional
	public List<Destination> listAll() {
		return this.destinationDao.listAll();
	}


	

}
