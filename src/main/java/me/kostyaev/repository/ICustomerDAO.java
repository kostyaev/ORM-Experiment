package me.kostyaev.repository;

import me.kostyaev.models.Customer;

import java.util.List;

public interface ICustomerDAO extends GenericDAO<Customer, Long> {

    List<Customer> getByLastName(String lastname);

}
