package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "subject_t")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id ")
    private Long subjectId;
    @Column(name = "subject_code")
    private String subjectCode;
    @Column(name = "subject_name")
    private String subjectName;
    private Integer credit;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<StudentScore> studentScores;
}