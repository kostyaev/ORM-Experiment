package me.kostyaev.repository.impl;

import me.kostyaev.models.Seller;
import me.kostyaev.repository.ISellerDAO;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SellerDAO extends HibernateGenericDAO<Seller, Long>
        implements ISellerDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Seller> getByLastName(String lastname) {
        return createCriteria()
                .add(Restrictions.eq("lastName", lastname))
                .list();
    }

}