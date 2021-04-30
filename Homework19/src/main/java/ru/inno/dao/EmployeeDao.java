package ru.inno.dao;

public interface EmployeeDao {
    void create(String name);
    void findById(int id);
    void updateById(int id);
    void deleteById(int id);
}
