package com.chair.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chair.model.Queries;
import com.mysql.cj.xdevapi.Session;

@Repository
public class QueriesDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public void addQuery(Queries queries) {
        Session session = sessionFactory.openSession();
        session.save(queries);
        session.flush();
        session.close();
    }

}
