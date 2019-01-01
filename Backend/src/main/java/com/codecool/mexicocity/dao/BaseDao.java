package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.util.TransactionHandler;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;


public abstract class BaseDao<T> {

    protected EntityManagerFactory emf;
    protected EntityTransaction transaction;

    Class<T> classType;

    BaseDao (Class<T> classType, EntityManagerFactory emf) {
        this.classType = classType;
        this.emf = emf;
        this.transaction = emf.createEntityManager().getTransaction();
    }

    public void add(T object){
       TransactionHandler.handleTransactionVoid(em -> em.persist(object));
    }

    public void update(T object){
        TransactionHandler.handleTransactionVoid(em -> em.merge(object));
    }

    public void remove(T object){ TransactionHandler.handleTransactionVoid(em -> em.remove(object)); }

    public List<Object> getAllObjects(String entityName) {
        EntityManager em = emf.createEntityManager();
        transaction.begin();
        String hql = "SELECT p FROM " + entityName + " AS p";
        Query query = (Query) em.createQuery(hql);
        List objects = query.list();
        transaction.commit();
        em.close();
        return objects;
    }

    public Object getObjectById(Long id) {

        EntityManager em = emf.createEntityManager();
        transaction.begin();
        Object object = em.find(classType, id);
        transaction.commit();
        em.close();
        return object;
    }


    public Object getObjectByField(Class entityClass, String fieldName,  String fieldValue){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<Object> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);

        ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get(fieldName), params));


        TypedQuery<Object> query = em.createQuery(criteriaQuery);
        query.setParameter(params, fieldValue);

        List<Object> queryResult = query.getResultList();

        Object returnObject = null;

        if (!queryResult.isEmpty()) {
            returnObject = queryResult.get(0);
        }
        em.close();
        return returnObject;

    }


    /*
    ALTERNATE OPTION IN CASE GETOBJECTBYFIELD WOULD NEED REFACTOR

    public Object getEmail(String email){
        EntityManager em = emf.createEntityManager();
        Query query = (Query) em.createQuery("from User u where u.email = :email ");
        query.setParameter("email", email);
        List list = query.list();
        em.close();
        return list.get(0);
    }
    */



}
