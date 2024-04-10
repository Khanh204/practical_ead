package controller;

import com.example.practical_ead.dto.StudentDTO;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<StudentDTO> getAll(){
        return studentService.getAllStudents();
    }

    @PostMapping()
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }
}


