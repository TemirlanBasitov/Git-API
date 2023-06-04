package com.gitapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.entity.Branch;
import com.gitapi.entity.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryServiceImpl implements  RepositoryService{
    @Override
    public List<Repository> getRepos(String username) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            String path = "https://api.github.com/users/" + username + "/repos";
            RestTemplate rest = new RestTemplate();
            String response = rest.getForObject(path, String.class);
            ArrayList<Repository> list = mapper.readValue(response, new TypeReference<ArrayList<Repository>>() {
            });
            ArrayList<Repository> notForkedRepositories = new ArrayList<>();
            list.forEach(repository -> {
                if(repository.getFork() == false){
                    List<Branch> branches = new ArrayList<>();
                    String branchesPath = String.format("https://api.github.com/repos/%s/%s/branches", repository.getOwner().getLogin(), repository.getName());
                    String branchesResponse = rest.getForObject(branchesPath, String.class);
                    try {
                        branches = mapper.readValue(branchesResponse, new TypeReference<ArrayList<Branch>>() {
                        });
                        repository.setBranches(branches);
                        notForkedRepositories.add(repository);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            return notForkedRepositories;


    }
}
