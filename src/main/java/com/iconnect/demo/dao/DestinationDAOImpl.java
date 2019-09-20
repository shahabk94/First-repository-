package com.iconnect.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import  com.iconnect.demo.domain.Destination;
import com.iconnect.demo.repository.DestinationRepository;

@XmlRootElement(name = "destination")
@Repository
public class DestinationDAOImpl implements DestinationDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	 @Autowired
	 DestinationRepository destinationRepository;
//	public void setSessionFactory(SessionFactory sf){
//		this.sessionFactory = sf;
//	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Destination> listDestinations() {
	//	Session session = sessionFactory.getCurrentSession();
		List destinationsList =new ArrayList();
		//List<Destination> destinationsList = session.createQuery("from Destination").list();
		//List<Destination> destinationsList = destinationRepository.findAll();
		  Iterable destinationsIterable=destinationRepository.findAll();
		  Iterator destinationsIterator=destinationsIterable.iterator();
		  while(destinationsIterator.hasNext())
		  {
			  destinationsList.add(destinationsIterator.next());
		  }
		
		return destinationsList;
	}


}
