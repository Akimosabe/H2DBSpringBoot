package ru.bogdanovakim.H2DBSpringBoot.dao;

import org.springframework.stereotype.Repository;
import ru.bogdanovakim.H2DBSpringBoot.entity.Student;

import java.util.List;

@Repository
public interface ServiceDAO {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}