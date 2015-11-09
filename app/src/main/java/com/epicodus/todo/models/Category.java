package com.epicodus.todo.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by nataliyamiller on 11/9/15.
 */

@Table(name = "Categories", id = "_id")

public class Category extends Model {

    @Column(name = "name")
    private String mName;

    public Category() {
        super();
    }

    public Category(String name) {
        super();
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public static List<Category> all() {
        return new Select().from(Category.class).execute();
    }

    public List<Task> tasks() {
        return getMany(Task.class, "Category");
    }

    public static Category find(String name) {
        return new Select()
                .from(Category.class)
                .where("name = ?", name)
                .executeSingle();
    }
}
