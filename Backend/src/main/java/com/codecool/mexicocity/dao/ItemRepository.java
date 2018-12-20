package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
