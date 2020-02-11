package com.qa.persistence.dao;

import java.util.List;

public interface Dao<T> {
    List<T> readAll();
     
    T create(T t);
     
    void update(T t);
     
    void delete(int id);
}
	