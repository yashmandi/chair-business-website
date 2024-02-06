package com.chair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chair.model.Customer;
import com.chair.model.User;
import com.chair.service.CustomerService;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer/registration")
    public ModelAndView getRegistrationForm() {
        Customer customer = new Customer();
        User user = new User();
        BillingAddress ba = new BillingAddress();
        ShippingAddress sa = new ShippingAddress();
        customer.setShippingAddress(sa);
        customer.setBillingAddress(ba);
        customer.setUser(user);

        return new ModelAndView("register", "customer", customer);
    }

    // insert the data
    @RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
    public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, Model model,
            BindingResult result) {
        if (result.hasErrors())
            return "register";
        customerService.addCustomer(customer);
        model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password");
        return "login";
    }
}