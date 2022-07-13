package com.staffing.user.service;

import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import com.staffing.user.entity.User;
import com.staffing.user.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User addAdmin(User admin) throws EmailAlreadyExistsException {
        if (userRepository.existsUserByEmail(admin.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.ROLE_ADMIN)) {
            roleRepository.save(new Role(RoleEnum.ROLE_ADMIN.toString()));
        }
        Role role = roleRepository.findRoleByName(RoleEnum.ROLE_ADMIN);
        admin.addRole(role);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return userRepository.save(admin);
    }
    public User FindUserByEmail(String email) throws NotFoundException {
        if(userRepository.existsUserByEmail(email)) {
            return userRepository.findUserByEmail(email);
        }
        throw new NotFoundException("User not found");
    }
}
