package ru.bogdanovakim.H2DBSpringBoot.controller.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bogdanovakim.H2DBSpringBoot.entity.Student;
import ru.bogdanovakim.H2DBSpringBoot.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        if (!allStudents.isEmpty()) {
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        if (savedStudent != null) {
            return new ResponseEntity<>("Студент добавлен", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Ошибка при добавлении", HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.saveStudent(student);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>("Студент удален", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("ID указан неверено", HttpStatus.NOT_FOUND);
        }
    }


}