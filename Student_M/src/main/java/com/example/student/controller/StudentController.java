package com.example.student.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.saveStudent(s);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student s) {
        s.setId(id);
        return service.updateStudent(s);
    }

    @PutMapping("/{id}/status")
    public Student updateStatus(@PathVariable int id, @RequestBody Map<String, String> body) {
        Student s = service.getStudentById(id).orElseThrow();
        s.setStatus(body.get("status")); // Cleaner and safer
        return service.updateStudent(s);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
