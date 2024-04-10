package service;

import com.example.practical_ead.dto.StudentDTO;
import com.example.practical_ead.dto.StudentScoreDTO;
import com.example.practical_ead.dto.SubjectDTO;
import entities.Student;
import entities.StudentScore;
import entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitories.StudentRepository;
import reponsitories.StudentScoreRepository;
import reponsitories.SubjectRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public List<StudentScoreDTO> getAllStudentScores() {
        List<StudentScore> studentScores = studentScoreRepository.findAll();
        List<StudentScoreDTO> studentScoreDTOs = new ArrayList<>();

        for (StudentScore studentScore : studentScores) {
            StudentScoreDTO studentScoreDTO = new StudentScoreDTO();
            studentScoreDTO.setStudentScoreId(studentScore.getStudentScoreId());
            studentScoreDTO.setStudentId(studentScore.getStudent().getStudentId());
            studentScoreDTO.setSubjectId(studentScore.getSubject().getSubjectId());
            studentScoreDTO.setScore1(studentScore.getScore1());
            studentScoreDTO.setScore2(studentScore.getScore2());


            StudentDTO studentDTO = new StudentDTO();
            Student student = studentScore.getStudent();
            if (student != null) {
                studentDTO.setStudentId(student.getStudentId());
                studentDTO.setStudentCode(student.getStudentCode());
                studentDTO.setFullName(student.getFullName());
                studentDTO.setAddress(student.getAddress());
            }
            studentScoreDTO.setStudent(studentDTO);

            SubjectDTO subjectDTO = new SubjectDTO();
            Subject subject = studentScore.getSubject();
            if (subject != null) {
                subjectDTO.setSubjectId(subject.getSubjectId());
                subjectDTO.setSubjectCode(subject.getSubjectCode());
                subjectDTO.setSubjectName(subject.getSubjectName());
                subjectDTO.setCredit(subject.getCredit());
            }
            studentScoreDTO.setSubject(subjectDTO);

            studentScoreDTOs.add(studentScoreDTO);
        }

        return studentScoreDTOs;
    }
    public StudentScoreDTO createStudentScore(StudentScoreDTO request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + request.getStudentId()));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + request.getSubjectId()));

        StudentScore studentScore = new StudentScore();
        studentScore.setStudent(student);
        studentScore.setSubject(subject);
        studentScore.setScore1(request.getScore1());
        studentScore.setScore2(request.getScore2());

        StudentScore savedStudentScore = studentScoreRepository.save(studentScore);

        StudentScoreDTO savedStudentScoreDTO = new StudentScoreDTO();
        savedStudentScoreDTO.setStudentScoreId(savedStudentScore.getStudentScoreId());
        savedStudentScoreDTO.setStudentId(savedStudentScore.getStudent().getStudentId());
        savedStudentScoreDTO.setSubjectId(savedStudentScore.getSubject().getSubjectId());
        savedStudentScoreDTO.setScore1(savedStudentScore.getScore1());
        savedStudentScoreDTO.setScore2(savedStudentScore.getScore2());

        StudentDTO studentDTO = new StudentDTO();
        Student student1 = savedStudentScore.getStudent();
        if (student1 != null) {
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentCode(student.getStudentCode());
            studentDTO.setFullName(student.getFullName());
            studentDTO.setAddress(student.getAddress());
        }
        savedStudentScoreDTO.setStudent(studentDTO);

        SubjectDTO subjectDTO = new SubjectDTO();
        Subject subject1 = savedStudentScore.getSubject();
        if (subject != null) {
            subjectDTO.setSubjectId(subject.getSubjectId());
            subjectDTO.setSubjectCode(subject.getSubjectCode());
            subjectDTO.setSubjectName(subject.getSubjectName());
            subjectDTO.setCredit(subject.getCredit());
        }
        savedStudentScoreDTO.setSubject(subjectDTO);

        return savedStudentScoreDTO;
    }
}