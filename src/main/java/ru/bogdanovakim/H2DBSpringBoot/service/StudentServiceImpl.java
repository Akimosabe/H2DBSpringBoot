package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.dao.ServiceDAO;
import ru.bogdanovakim.H2DBSpringBoot.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ServiceDAO serviceDAO;
    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return serviceDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return serviceDAO.getStudent(id);
    }


    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return serviceDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        serviceDAO.deleteStudent(id);
    }
}