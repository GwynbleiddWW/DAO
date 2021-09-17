package ru.netology.dao;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }


    public String getProductName(String productName) {
        return repository.getProductName(productName);
    }
}
