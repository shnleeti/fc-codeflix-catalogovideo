package com.shnleeti.catalogovideoapi.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Genre extends BaseEntity{

    private String name;
    private List<Category> categories = new ArrayList<>();

    public Genre() {
    }

    public Genre(String name) {
        super.generateUUID();
        this.name = name;
    }

    public Genre(UUID id, String name){
        super.setId(id);
        this.name = name;
    }
    
    public Genre(String name, List<Category> categories) {
        super.generateUUID();
        this.name = name;
        this.categories = categories;
        
    }


    public Genre(UUID id, String name, List<Category> categories) {
        super.setId(id);
        this.name = name;
        this.categories = categories;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        if (name == null) throw new IllegalArgumentException("Name is marked non-null but is null");
        if (name.length() == 0) throw new IllegalArgumentException("Name is marked non-blank but is blank");
        this.name = name;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        if (categories == null) throw new IllegalArgumentException("Categories is marked non-null but is null");

        this.categories = categories;
    }


    public void addCategory(Category category){
        if (category == null) throw new IllegalArgumentException("Category is marked non-null but is null");

        this.categories.add(category);

    }
    
    public void removeCategory(Category category){
        if (category == null) throw new IllegalArgumentException("Category is marked non-null but is null");

        System.out.println("antes de remover" + this.categories.toString());
        this.categories.remove(category);
        // this.categories.removeIf(c -> c.equals(category));
        System.out.println(this.categories.toString());

    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", categories='" + getCategories() + "'" +
            "}";
    }


}
