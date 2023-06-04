package com.gitapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gitapi.entity.Repository;

import java.util.List;

public interface RepositoryService {
    List<Repository> getRepos(String username) throws JsonProcessingException;
}
