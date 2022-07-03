package com.staffing.user.repository;

import com.staffing.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    boolean existsUserByEmail(String email);
}
