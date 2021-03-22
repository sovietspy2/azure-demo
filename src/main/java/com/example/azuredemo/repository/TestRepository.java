package com.example.azuredemo.repository;


import com.example.azuredemo.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {

    @Query("Select t from Test t where t.name = ?1")
    Optional<Test> findWithCustomQuery(String nameParam);
}
