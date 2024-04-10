package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "student_t")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id ")
    private Long studentId;
    @Column(name = "student_code")
    private String studentCode;
    @Column(name = "full_name")
    private String fullName;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<StudentScore> studentScores;
}