package com.example.spring_boot_api.entity;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted <> 1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String employeeNumber;
    private String name;
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;

    // private Integer departmentId;
    // private Integer groupId;
    // private Integer positionId;
}