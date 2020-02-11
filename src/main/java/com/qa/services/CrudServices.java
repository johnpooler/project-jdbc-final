package com.qa.services;

import java.util.List;

public interface CrudServices<T> {
    public List<T> readAll();
     
    T create(T t);
     
    void update(T t);
 
    void delete(int id);
}