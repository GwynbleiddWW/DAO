package ru.netology.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String fetchProduct(@RequestParam("name") String name) {
        return service.getProductName(name);
    }
}
