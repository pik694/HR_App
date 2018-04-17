package com.bartek.myapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Set <Category> subcategories;
    private String name;
    @OneToMany
    private Set <Item> items;
}
