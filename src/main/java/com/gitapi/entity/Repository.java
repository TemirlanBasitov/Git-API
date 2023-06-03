package com.gitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {


    private String name;
    private Owner owner;
    private Boolean fork;
    private List<Branch> branches;

    public Repository(){};

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getFork() {
        return fork;
    }

    public List<Branch> getBranches() {
        return branches;
    }
}
