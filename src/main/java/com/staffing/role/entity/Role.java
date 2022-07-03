package com.staffing.role.entity;



import com.staffing.role.enums.RoleEnum;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "role",uniqueConstraints = {@UniqueConstraint(name = "role_name_unique", columnNames = "name")})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false,length = 100)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Role(Long id){
        super();
        this.id = id;
    }
    public Role(String name) {
        this.name = RoleEnum.valueOf(RoleEnum.class,name);
    }

    public Role() {

    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = RoleEnum.valueOf(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(String name) {
        this.name = RoleEnum.valueOf(name);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

}


