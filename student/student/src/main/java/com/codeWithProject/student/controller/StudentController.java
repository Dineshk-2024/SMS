package com.codeWithProject.student.controller;

import com.codeWithProject.student.entity.Student;
import com.codeWithProject.student.repository.StudentRepository;
import com.codeWithProject.student.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student){
        return studentService.postStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        try{
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student with ID " + id + " deleted successfully", HttpStatus.OK);
        }catch(EntityNotFoundException s){
            return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        if(student ==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }
    @PatchMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student updateStudent = studentService.updateStudent(id, student);

        if(updateStudent == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateStudent);
    }
}
