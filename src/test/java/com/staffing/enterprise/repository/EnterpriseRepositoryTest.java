package com.staffing.enterprise.repository;

import com.staffing.enterprise.entity.Enterprise;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EnterpriseRepositoryTest {
    static  int insertionCount = 0;
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Test
    void findByEmail() {
        Enterprise enterprise6 = new Enterprise();
        enterprise6.setEmail("enterprise6@enterprise6.com");
        enterprise6.setEnterpriseName("enterprise6");
        enterprise6.setPassword("enterprise6");
        enterpriseRepository.save(enterprise6);
        insertionCount++;
        assertEquals(enterpriseRepository.findByEmail("enterprise6@enterprise6.com"), enterprise6);
    }


    @Test
    void findByEnterpriseName() {
        Enterprise enterprise5 = new Enterprise();
        enterprise5.setEmail("enterprise5@enterprise5.com");
        enterprise5.setEnterpriseName("enterprise5");
        enterprise5.setPassword("enterprise5");
        enterpriseRepository.save(enterprise5);
        insertionCount++;
        assertEquals(enterpriseRepository.findByEnterpriseName("enterprise5"), enterprise5);
    }
    @Test
    void existsByEmail() {
        Enterprise enterprise4 = new Enterprise();
        enterprise4.setEmail("enterprise4@enterprise4.com");
        enterprise4.setEnterpriseName("enterprise4");
        enterprise4.setPassword("enterprise4");
        enterpriseRepository.save(enterprise4);
        insertionCount++;
        assertTrue(enterpriseRepository.existsByEmail("enterprise4@enterprise4.com"));
    }
    @Test
    void existsByEnterpriseName() {
        Enterprise enterprise3 = new Enterprise();
        enterprise3.setEmail("enterprise3@enterprise3.com");
        enterprise3.setEnterpriseName("enterprise3");
        enterprise3.setPassword("enterprise3");
        insertionCount++;
        enterpriseRepository.save(enterprise3);
        assertTrue(enterpriseRepository.existsByEnterpriseName("enterprise3"));
    }
    @Test
    void addEnterprises(){
        Enterprise enterprise1 = new Enterprise();
        enterprise1.setEmail("enterprise1@enterprise1.com");
        enterprise1.setEnterpriseName("enterprise1");
        enterprise1.setPassword("enterprise1");
        insertionCount++;
        Enterprise enterprise2 = new Enterprise();
        enterprise2.setEmail("enterprise2@enterprise2.com");
        enterprise2.setEnterpriseName("enterprise2");
        enterprise2.setPassword("enterprise2");
        insertionCount++;
        enterpriseRepository.saveAll(Arrays.asList(enterprise1, enterprise2));
        assertEquals(insertionCount, enterpriseRepository.count());
    }
}