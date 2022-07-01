package com.staffing.admin.entity;

import com.staffing.role.entity.Role;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "Admin")
@Table(name = "admin", uniqueConstraints = {@UniqueConstraint(name = "admin_email_unique", columnNames = "email")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "password", nullable = false)
    @Length(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    private Collection<Role> roles = new ArrayList<Role>();

    public Admin(String email, String password, String firstName, String lastName, ArrayList<Role> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setRole(Role role) {
        roles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
