package me.kostyaev.repository.impl;

import me.kostyaev.models.Customer;
import me.kostyaev.repository.ICustomerDAO;

public class CustomerDAO extends HibernateGenericDAO<Customer, Long>
        implements ICustomerDAO {


}