package me.kostyaev.repository;

import me.kostyaev.models.Order;

import java.util.List;

public interface IOrderDAO extends GenericDAO<Order, Long> {

    List<Order> getOrderByPayed(boolean payed);

}
