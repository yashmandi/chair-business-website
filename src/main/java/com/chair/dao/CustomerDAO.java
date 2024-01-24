package com.chair.dao;

import com.chair.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDao {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public CustomerDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Customer getCustomerById(int customerId) {
        return hibernateTemplate.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    public void saveCustomer(Customer customer) {
        hibernateTemplate.save(customer);
    }

    public void updateCustomer(Customer customer) {
        hibernateTemplate.update(customer);
    }

    public void deleteCustomer(int customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            hibernateTemplate.delete(customer);
        }
    }
}
