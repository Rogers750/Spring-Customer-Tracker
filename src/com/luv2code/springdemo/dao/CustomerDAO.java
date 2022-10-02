package com.luv2code.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;

@Component
public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer modelCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
