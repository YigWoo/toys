package com.yigwoo.univs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Province {
    private String id;
    private List<Univ> univs;
    private String name;

    @JsonProperty("country_id")
    private String countryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", univs=" + univs +
                ", name='" + name + '\'' +
                ", countryId='" + countryId + '\'' +
                '}';
    }

    public List<Univ> getUnivs() {
        return univs;
    }

    public void setUnivs(List<Univ> univs) {
        this.univs = univs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
