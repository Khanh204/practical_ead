package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "student_score_t")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id ")
    private Long studentScoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id ")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id  ")
    private Subject subject;

    private Double score1;
    private Double score2;
}