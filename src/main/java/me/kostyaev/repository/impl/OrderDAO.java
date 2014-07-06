package me.kostyaev.repository.impl;

import me.kostyaev.models.Order;
import me.kostyaev.repository.IOrderDAO;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class OrderDAO extends HibernateGenericDAO<Order, Long>
        implements IOrderDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrderByPayed(boolean payed) {
        return createCriteria()
                .add(Restrictions.eq("payed", payed))
                .list();

    }

}