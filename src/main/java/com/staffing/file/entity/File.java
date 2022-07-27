package com.staffing.file.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.staffing.employee.entity.Employee;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Lob
    @Column
    private String content;
    @Column
    private String fileType;
    @ManyToOne
    @JsonBackReference
    private Employee employee;

    public File() {
    }

    public File(String name, String content, String fileType) {
        this.name = name;
        this.content = content;
        this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
