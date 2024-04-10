package reponsitories;

import entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface StudentRepository extends JpaRepository<Student,Long> {
}
