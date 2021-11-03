package com.shnleeti.catalogovideoapi.domain.entity;

import java.util.UUID;

public class Category extends BaseEntity {

    private String name;

    public Category(){}
    
    public Category(String name){
        super.generateUUID();
        this.setName(name);
    }

    public Category(UUID id){
        super.setId(id);
    }

    public Category(UUID id, String name){
        super.setId(id);
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name is marked non-null but is null");
        if (name.length() == 0) throw new IllegalArgumentException("Name is marked non-blank but is blank");
        this.name = name;
    }

}
