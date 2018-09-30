package com.yanzi.study.lession18.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*
*@author yanzi
*@Date 10:53 2018/9/19
**/
@Entity
public class Authority {

    @Id
    @NotNull
    @Size(min = 0,max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if (obj == null || getClass()!= obj.getClass())return false;

        Authority authority = (Authority) obj;

        if (!name.equals(authority.getName()))return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Authority{"+"name='"+name+'\''+'}';
    }
}
