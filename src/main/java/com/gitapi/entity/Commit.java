package com.gitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {
    private String sha;

    public Commit() {
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit(String sha) {
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }
}
