package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudent();

    Student getStudent(int id);

    Student saveStudent(Student student);

    void deleteStudent(int id);
}