package com.codeWithProject.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Data
@JsonPropertyOrder({"id", "name", "email", "phone", "course", "feesPaid", "feesBal"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String course;

    private String feesPaid;

    private String feesBal;
}
