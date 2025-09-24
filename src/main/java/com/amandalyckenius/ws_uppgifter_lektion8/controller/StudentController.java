package com.amandalyckenius.ws_uppgifter_lektion8.controller;


import com.amandalyckenius.ws_uppgifter_lektion8.model.Student;
import com.amandalyckenius.ws_uppgifter_lektion8.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student.setId(null);
        Student saved = repo.save(student);
        return ResponseEntity
                .created(URI.create("/students/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return repo.findAll();
    }


}
