package com.codecool.mexicocity.util;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface TransactionVoid {

    void transactionMethod(EntityManager em);
}
