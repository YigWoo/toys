package com.yichao.woo.univs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Univ {
    private String id;
    private String name;

    @JsonIgnore
    private List<String> departments = new ArrayList<String>();

    @JsonIgnore
    private List<String> dorms = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public List<String> getDorms() {
        return dorms;
    }

    public void setDorms(List<String> dorms) {
        this.dorms = dorms;
    }

    @Override
    public String toString() {
        return "Univ{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
