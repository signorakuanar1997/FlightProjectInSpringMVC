package com.coforge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.coforge.entity.Flight;
import com.coforge.dao.*;
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@Override
	public void saveFlight(Flight flight) {
		getSession().save(flight);

	}

	@Transactional
	@Override
	public void updateFlight(Flight flight) {
		getSession().update(flight);

	}

	@Transactional
	@Override
	public void deleteFlight(Long id) {
		Flight flight = getFlightById(id);
		if (flight != null) {
			getSession().delete(flight);
		}

	}

	@Transactional(readOnly = true)
	@Override
	public Flight getFlightById(Long id) {
		return getSession().get(Flight.class, id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Flight> getAllFlights() {
		return getSession().createQuery("from Flight", Flight.class).list();
	}

}
