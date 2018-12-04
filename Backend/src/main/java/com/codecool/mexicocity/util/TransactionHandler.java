package com.codecool.mexicocity.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionHandler {

    private TransactionHandler(){}

    public static void handleTransactionVoid(TransactionVoid voidMethod){
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        voidMethod.transactionMethod(em);
        transaction.commit();
        em.close();
    }
}
