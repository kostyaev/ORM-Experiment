package me.kostyaev.repository.impl;

import me.kostyaev.models.Order;
import me.kostyaev.repository.IOrderDAO;

public class OrderDAO extends HibernateGenericDAO<Order, Long>
        implements IOrderDAO {


}