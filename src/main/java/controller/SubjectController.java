package controller;

import com.example.practical_ead.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping()
    public List<SubjectDTO> getAll(){
        return subjectService.getAllSubjects();
    }

    @PostMapping()
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }

}