package com.trilogyed.AdminAPI.util;

import com.trilogyed.AdminAPI.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer")
public interface CustomerServiceClient {

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    Customer createCustomerCont (@RequestBody Customer customer);

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    Customer getCustomerByIdCont (@PathVariable int id);

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    List<Customer> getAllCustomerCont();

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.PUT)
    void updateCustomerCont (@PathVariable ("id")int id,@RequestBody Customer customer);

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.DELETE)
    void deleteCustomerCont (@PathVariable int id);



    }
