package com.staffing.user.repository;

import com.staffing.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void addUsersToDbValid(){
        User ahmed = new User();
        ahmed.setEmail("ahmed@ahmed.com");
        ahmed.setPassword("12345678");
        User ala = new User();
        ala.setEmail("ala@ala.com");
        ala.setPassword("12345678");
        userRepository.saveAll(List.of(ahmed,ala));
        assertEquals(3,userRepository.count());
    }
    @Test
    void findUserByEmailValid() {
        User user = new User();
        user.setEmail("user@user.com");
        user.setPassword("12345678");
        userRepository.save(user);
        assertEquals(user,userRepository.findUserByEmail("user@user.com"));
    }
    @Test
    void findUserByEmailInvalid() {
        User user = new User();
        user.setEmail("azer@azer.com");
        user.setPassword("12345678");
        assertNull(userRepository.findUserByEmail(user.getEmail()));
    }
}