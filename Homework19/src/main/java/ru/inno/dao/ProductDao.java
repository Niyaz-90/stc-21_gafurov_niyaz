package ru.inno.dao;

public interface ProductDao {
    void create(String name);
    void findById(int productId);
    void updateById(int productId);
    void deleteById(int productId);
}
