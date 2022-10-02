package com.luv2code.springdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
    private CustomerService customerService;



	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	       //get the customers from customer DAO
		List<Customer> theCustomers= customerService.getCustomers();
		// add these customers to Model

		theModel.addAttribute("customers",theCustomers);

		return "list-customers";
	}


	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer theCustomer= new Customer();

		model.addAttribute("customer", theCustomer);

		return "customer-form";
	}


	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer modelCustomer) {

		customerService.saveCustomer(modelCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId")int id, Model theModal) {
		Customer theCustomer=customerService.getCustomer(id);
		theModal.addAttribute("customer",theCustomer);

		return "customer-form";
	}
	
	@RequestMapping("/deleteFormItem")
	public String deleteFormItem(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
