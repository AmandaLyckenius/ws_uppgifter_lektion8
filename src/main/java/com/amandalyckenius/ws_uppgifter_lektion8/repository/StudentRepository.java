package com.amandalyckenius.ws_uppgifter_lektion8.repository;

import com.amandalyckenius.ws_uppgifter_lektion8.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentById (Long id);
}
