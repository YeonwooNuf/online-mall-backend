package com.learn.service;

import com.learn.mapper.ProductMapper;
import com.learn.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<ProductVO> getAllProducts() {
        List<ProductVO> result = productMapper.getAllProducts();

        return result;
    }
}
