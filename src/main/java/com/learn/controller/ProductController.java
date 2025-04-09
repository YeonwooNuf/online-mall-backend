package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ProductController {

    @PostMapping("/products")
    public List<Map<String, Object>> getAllProducts(@RequestBody HashMap<String, Object> form) {

        List<Map<String, Object>> result = new ArrayList<>()
                ;
        Map<String, Object> data1 = new HashMap<>();
        data1.put("id", 1);
        data1.put("name", "Laptop");
        data1.put("price", 1200);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("id", 2);
        data2.put("name", "Phone");
        data2.put("price", 800);

        Map<String, Object> data3 = new HashMap<>();
        data3.put("id", 3);
        data3.put("name", "Tablet");
        data3.put("price", 400);

        result.add(data1);
        result.add(data2);
        result.add(data3);

        return result;
    }
}
