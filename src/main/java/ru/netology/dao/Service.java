package ru.netology.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.stereotype.Service
public class Service  implements CommandLineRunner {

    Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate template;


    //???
    public static String getProductName(String productName) {
        return 
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
}
