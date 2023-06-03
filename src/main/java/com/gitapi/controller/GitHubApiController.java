package com.gitapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.entity.Branch;
import com.gitapi.entity.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubApiController {
    private static final String ACCEPT_JSON = "application/json";
    private static final String ACCEPT_XML = "application/xml";

    @GetMapping("/repositories/{username}")
    public ResponseEntity<ArrayList<Repository>> getRepos(@PathVariable String username, @RequestHeader("Accept") String acceptHeader) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            String path = "https://api.github.com/users/" + username + "/repos";
            System.out.println(path);
            RestTemplate rest = new RestTemplate();
            String response = rest.getForObject(path, String.class);
            ArrayList<Repository> list = mapper.readValue(response, new TypeReference<ArrayList<Repository>>() {});
            list.forEach( repository -> {

                List<Branch> branches = new ArrayList<>();
                String branchesPath = String.format("https://api.github.com/repos/%s/%s/branches", repository.getOwner().getLogin(), repository.getName());
                String branchesResponse = rest.getForObject(branchesPath,String.class );
                try {
                    branches = mapper.readValue(branchesResponse, new TypeReference<ArrayList<Branch>>() {});
                    repository.setBranches(branches);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            });
            return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
