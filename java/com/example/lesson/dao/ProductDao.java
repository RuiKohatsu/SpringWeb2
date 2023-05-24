package com.example.lesson.dao;

import com.example.lesson.entity.Product;
import com.example.lesson.record.ProductRecord;

import java.util.List;

public interface ProductDao {
    List<ProductRecord> findAll();

    ProductRecord findById(int id);

    int insert(String name, int price);

    int update(int id, String name, int price);

    int delete(int id);

}