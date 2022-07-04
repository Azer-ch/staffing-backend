package com.staffing.enterprise.service;

import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.exceptions.NameAlreadyExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnterpriseServiceTest {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Test
    void addEnterpriseEmailInvalid() {
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("enterprise1");
        enterprise.setEmail("enterprise@enterprise.com");
        enterprise.setPassword("password");
        assertThrows(EmailAlreadyExistsException.class, () -> {
            enterpriseService.addEnterprise(enterprise);
        });
    }

    @Test
    void addEnterpriseNameInvalid() {
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("enterprise");
        enterprise.setEmail("enterprise@enterprise1.com");
        enterprise.setPassword("password");
        assertThrows(NameAlreadyExistsException.class, () -> {
            enterpriseService.addEnterprise(enterprise);
        });
    }

    @Test
    void deleteEnterpriseValid() {
        Enterprise enterprise = enterpriseRepository.findByEnterpriseName("enterprise");
        assertDoesNotThrow(() -> enterpriseService.deleteEnterprise(enterprise.getEnterpriseName()));
        assertFalse(enterpriseRepository.findByEnterpriseName(enterprise.getEnterpriseName()).isActive());
    }
    @Test
    void deleteEnterpriseInvalid(){
        assertThrows(NameAlreadyExistsException.class, () -> {
            enterpriseService.deleteEnterprise("enterprise");
        });
    }

    @Test
    void addEnterpriseValid() {
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("enterprise");
        enterprise.setEmail("enterprise@enterprise.com");
        enterprise.setPassword("password");
        assertDoesNotThrow(() -> {
            enterpriseService.addEnterprise(enterprise);
        });
    }

}