package com.qa.ims.services;

import java.util.List;

public interface CrudServices<T> {
    public List<T> readAll();
     
    T create(T t);
     
<<<<<<< HEAD:src/main/java/com/qa/services/CrudServices.java
    void update(T t);
 
    void delete(int id);
}
=======
    T update(T t);
 
    void delete(Long id);

}
>>>>>>> daaa61cbbe27f08d182f3eeb0a9d53945b58fdbb:src/main/java/com/qa/ims/services/CrudServices.java
