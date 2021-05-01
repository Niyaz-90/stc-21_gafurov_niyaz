package ru.inno.dao;

public interface ProductDao {
    void create(String name, int cost);
    void findById(int productId);
    void updateById(int productId, String name, int cost);
    void deleteById(int productId);
}
