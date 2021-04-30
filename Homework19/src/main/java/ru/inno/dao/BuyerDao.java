package ru.inno.dao;

public interface BuyerDao {
    void create(String name);
    void findById(int buyerId);
    void updateById(int buyerId);
    void deleteById(int buyerId);
}
