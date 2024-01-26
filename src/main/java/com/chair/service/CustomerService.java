package com.chair.service;

import java.util.List;

import com.chair.model.Customer;

public class CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerByemailId(String emailId);

}
