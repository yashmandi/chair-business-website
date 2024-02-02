package com.chair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chair.dao.QueriesDAO;
import com.chair.model.Queries;

@Service
public class QueriesServiceImpl {

    @Autowired
    private QueriesDAO queriesDAO;

    public void addQuery(Queries queries) {
        queriesDAO.addQuery(queries);
    }

}
