package service;

import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;
public List<Student> getAll(){
    return studentRepository.findAll();
}
public Student createStudent(Student student){
    return studentRepository.save(student);
}
public Student updateStudent(Long student_id,Student student){
    return studentRepository.findById(student_id)
            .map(s->{
                s.setStudent_code(student.getStudent_code());
                s.setFull_name(student.getFull_name());
                s.setAddress(student.getAddress());
                s.setStudentScores(student.getStudentScores());
                return studentRepository.save(s);
            })
            .orElseGet(()->{
                student.setStudent_id(student_id);
                return studentRepository.save(student);
            });
}
public void deleteStudent(Long student_id){
            studentRepository.deleteById(student_id);
}
}
