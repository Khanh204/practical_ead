package service;


import entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reponsitories.SubjectRepository;

import java.util.List;
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public List<Subject> getAll(){
        return subjectRepository.findAll();
    }
    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public Subject updateSubject(Long subject_id,Subject subject){
        return subjectRepository.findById(subject_id)
                .map(sub->{
                    sub.setSubject_code(subject.getSubject_code());
                    sub.setSubject_name(subject.getSubject_name());
                    sub.setCredit(subject.getCredit());
                    sub.setStudentScores(subject.getStudentScores());
                    return subjectRepository.save(sub);
                })
                .orElseGet(()->{
                    subject.setSubject_id(subject_id);
                    return subjectRepository.save(subject);
                });
    }
    public void deleteSubject(Long subject_id){
        subjectRepository.deleteById(subject_id);
    }
}
