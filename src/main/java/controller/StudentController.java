package controller;

import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
@Autowired
private StudentService studentService;
@GetMapping()
public List<Student> getAllStudent(){
    return studentService.getAll();
}
    @PostMapping()
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping("/{student_id}")
    public Student updateStudent(@PathVariable Long student_id,@RequestBody Student student){
        return studentService.updateStudent(student_id,student);
    }
    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable Long student_id){
        studentService.deleteStudent(student_id);
    }

}
