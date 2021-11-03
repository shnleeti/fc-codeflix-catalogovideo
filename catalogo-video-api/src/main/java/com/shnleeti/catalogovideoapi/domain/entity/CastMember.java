package com.shnleeti.catalogovideoapi.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum CastMemberType {
    TYPE1(1),
    TYPE2(2);

    private Integer type;
    private final static Map<Integer,CastMemberType> values = new HashMap<>();

    private CastMemberType(Integer type) {
        this.type = type;
    }

    static {
        for(CastMemberType type : CastMemberType.values()) {
            System.out.println("ADD STATIC TYPE: " + type.toString());
            values.put(type.type, type);
        }
    }

    public Integer getType() {
        return this.type;
    }

    public static Boolean valueOf(CastMemberType type) {
        CastMemberType castMemberType = values.get(type.type);

        if (castMemberType == null) {
            System.out.println("Type is null");
            return false;
        }
        return true;
    }

}

public class CastMember extends BaseEntity {

    private String name;
    private CastMemberType type;

    // public CastMember() {
    // }


    public CastMember(UUID id, String name, CastMemberType type) {
        super.setId(id);
        setName(name);
        setType(type);
    }

    public CastMember( String name, CastMemberType type) {
        super.generateUUID();
        setName(name);
        setType(type);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name is marked non-null but is null");
        if(name.length() == 0) throw new  IllegalArgumentException("Name is marked non-bank but is blank");
        this.name = name;
    }

    public CastMemberType getType() {
        return this.type;
    }

    public void setType(CastMemberType type) {
        if (type == null) throw new IllegalArgumentException("Type is marked non-null but is null");
        if(!CastMemberType.valueOf(type)) throw new  IllegalArgumentException("Type is marked as valid enum but is not valid");
        this.type = type;
    }


}
