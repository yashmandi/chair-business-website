package com.chair.service;

import java.util.List;

import com.chair.model.Customer;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerByemailId(String emailId);

}
