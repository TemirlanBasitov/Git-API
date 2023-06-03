package com.gitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    private String name;
    private Commit commit;

    public Branch(String name, Commit commit) {
        this.name = name;
        this.commit = commit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }

    public Branch(){};
}
