package com.staffing.role.entity;


import com.staffing.role.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Role")
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(name = "role_name_unique", columnNames = "name")})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name", nullable = false,length = 100)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Role(RoleEnum name) {
        this.name = name;
    }
}


