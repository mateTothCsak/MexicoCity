package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class ItemDao extends BaseDao {

    public ItemDao(EntityManagerFactory emf) {
        super(Item.class, emf);
    }

}
