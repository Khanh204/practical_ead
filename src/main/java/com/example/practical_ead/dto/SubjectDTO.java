package com.example.practical_ead.dto;

import lombok.Data;

@Data
public class SubjectDTO {
    private Long subjectId;
    private String subjectCode;
    private String subjectName;
    private Integer credit;
}
