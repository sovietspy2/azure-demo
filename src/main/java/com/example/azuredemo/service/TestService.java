package com.example.azuredemo.service;

import com.example.azuredemo.model.Test;
import com.example.azuredemo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    public void testSave(Test test) {
        testRepository.save(test);
    }

    @Transactional
    public void testSaveRollback(Test test) {
        testRepository.save(test);

        throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
    }


}
