package me.kostyaev.repository;

import me.kostyaev.models.Seller;

import java.util.List;

public interface ISellerDAO extends GenericDAO<Seller, Long> {

    List<Seller> getByLastName(String lastname);

}
