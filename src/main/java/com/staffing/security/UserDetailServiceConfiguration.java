package com.staffing.security;

import com.staffing.admin.entity.Admin;
import com.staffing.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@RequiredArgsConstructor
public class UserDetailServiceConfiguration implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (adminRepository.existsAdminByEmail(email)) {
            return adminRepository.findAdminByEmail(email);
        } else {
            throw new UsernameNotFoundException("Admin not found");
        }
    }
}