package com.shahab.spring.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shahab.spring.model.Destination;



@XmlRootElement(name = "destination")
@Repository

public class DestinationDao {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Destination> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Destination> destinationsList = session.createQuery("from Destination").list();
		return destinationsList;
	}

}
