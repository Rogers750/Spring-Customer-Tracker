package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
@Component
public class customerDAOImpl implements CustomerDAO {

	//inject hibernate session factory


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {

		//current hibernate session

		Session currentSession=sessionFactory.getCurrentSession();


		//create query

		Query<Customer> query=currentSession.createQuery("from Customer order by lastName ASC",Customer.class);

		//get customer list

		List<Customer> customers= query.getResultList();

		//return customer list

		return customers;
	}

	@Override
	public void saveCustomer(Customer modelCustomer) {

		Session currentSession=sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(modelCustomer);

	}

	@Override
	public Customer getCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer= currentSession.get(Customer.class, id);
		return theCustomer;
	}

//	@Override
//	public void deleteCustomer(int id) {
//		Session currentSession=sessionFactory.getCurrentSession();
//		//Customer theCustomer=currentSession.get(Customer.class, id);
//		Query<Customer> query= currentSession.createQuery("delete from Customer where id=:customerId");
//		query.setParameter("customerId", id);
//		query.executeUpdate();
//	}

	@Override
	public void deleteCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class, id);
		currentSession.delete(theCustomer);
	}


}
