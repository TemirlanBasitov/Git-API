package com.gitapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gitapi.entity.Repository;
import com.gitapi.exception.XmlTypeExceptionWrapper;
import com.gitapi.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubApiController {
    RepositoryService repositoryService;
    public GitHubApiController(RepositoryService repositoryService){
        this.repositoryService = repositoryService;
    }
    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<Repository>> getRepos(@PathVariable String username, @RequestHeader("Accept") String acceptHeader) throws JsonProcessingException {
       if("application/json".equalsIgnoreCase(acceptHeader)){
           List<Repository> repositories = repositoryService.getRepos( username);
           return  new ResponseEntity<>(repositories, HttpStatus.OK);
       }
       else if(acceptHeader != null && acceptHeader.toLowerCase().startsWith("application/xml")){
           throw new XmlTypeExceptionWrapper("Requested content type is not supported. Please use 'application/json' for the Accept header.");

       }
       else {
           throw new XmlTypeExceptionWrapper("Requested content type is not supported. Please use 'application/json' for the Accept header.");
       }

    }
}
