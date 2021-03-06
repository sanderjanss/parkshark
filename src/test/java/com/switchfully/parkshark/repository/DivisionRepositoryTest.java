package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Division;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @BeforeAll
    void setUp() {
        divisionRepository.save(new Division());

    }


    @Test
    public void findAll() {
        var toCheck = divisionRepository.findAll().size();
        Assertions.assertEquals(1, toCheck);

    }

    @Test
    public void findById() {
        var toCheck = divisionRepository.findByDivisionId(1);
        Assertions.assertNotNull(toCheck);

    }

    @Test
    public void save() {
        divisionRepository.save(new Division());
        var toCheck = divisionRepository.findAll().size();
        Assertions.assertEquals(2, toCheck);

    }


}