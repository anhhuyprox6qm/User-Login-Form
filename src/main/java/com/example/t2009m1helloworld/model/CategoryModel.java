package com.example.t2009m1helloworld.model;
import com.example.t2009m1helloworld.entity.Category;
import java.util.List;

public interface CategoryModel {
    boolean save(Category category);
    boolean update(int id, Category category);
    boolean delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
