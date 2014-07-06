package me.kostyaev.repository.impl;

import me.kostyaev.models.Customer;
import me.kostyaev.repository.ICustomerDAO;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CustomerDAO extends HibernateGenericDAO<Customer, Long>
        implements ICustomerDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> getByLastName(String lastname) {
        return createCriteria()
                .add(Restrictions.eq("lastName", lastname))
                .list();
    }

}