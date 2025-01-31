package com.example.hrworker.resourcers;

import java.util.List;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResouce {
    

    private static Logger logger = LoggerFactory.getLogger(WorkerResouce.class);

    @Value("${test.config}")
    private String testConfig;


    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
       logger.info("CONFIG = " + testConfig);
       return ResponseEntity.noContent().build();
    }
}
