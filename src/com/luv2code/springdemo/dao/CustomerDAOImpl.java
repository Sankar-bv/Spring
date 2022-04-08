package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query order by lastname
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Save/Update the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Now retrieve data from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Delete object with primary key
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
