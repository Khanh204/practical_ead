package com.example.practical_ead.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long studentId;

    private String studentCode;

    private String fullName;
    private String address;
}