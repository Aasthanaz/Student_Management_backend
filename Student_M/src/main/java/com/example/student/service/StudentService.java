package com.example.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repo.findById(id);
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return repo.save(student);
    }
}
