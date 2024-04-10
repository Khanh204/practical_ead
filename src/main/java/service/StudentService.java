package service;

import com.example.practical_ead.dto.StudentDTO;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentCode(student.getStudentCode());
            studentDTO.setFullName(student.getFullName());
            studentDTO.setAddress(student.getAddress());
            studentDTOs.add(studentDTO);
        }

        return studentDTOs;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentCode(studentDTO.getStudentCode());
        student.setFullName(studentDTO.getFullName());
        student.setAddress(studentDTO.getAddress());

        Student savedStudent = studentRepository.save(student);

        StudentDTO savedStudentDTO = new StudentDTO();
        savedStudentDTO.setStudentId(savedStudent.getStudentId());
        savedStudentDTO.setStudentCode(savedStudent.getStudentCode());
        savedStudentDTO.setFullName(savedStudent.getFullName());
        savedStudentDTO.setAddress(savedStudent.getAddress());

        return savedStudentDTO;
    }

}