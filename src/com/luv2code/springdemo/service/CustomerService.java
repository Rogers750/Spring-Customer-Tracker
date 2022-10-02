package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;

@Component
public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer modelCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
