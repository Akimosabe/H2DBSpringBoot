package ru.bogdanovakim.H2DBSpringBoot.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bogdanovakim.H2DBSpringBoot.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        try {
            Query query = entityManager.createQuery("from Student");
            List<Student> allStudents = query.getResultList();
            log.info("getAllStudents: Получено " + allStudents.size() + " студентов");
            return allStudents;
        } catch (Exception e) {
            log.error("Ошибка при получении списка студентов: " + e.getMessage(), e);
            throw e;
        }
    }


    @Override
    public Student saveStudent(Student student) {
        try {
            Student savedStudent = entityManager.merge(student);
            log.info("Сохранен студент: ID " + savedStudent.getId());
            return savedStudent;
        } catch (Exception e) {
            log.error("Ошибка при сохранении студента: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Student getStudent(int id) {
        try {
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                log.info("Студент сохранен: ID " + id);
            } else {
                log.info("Студент: ID " + id + " не найден");
            }
            return student;
        } catch (Exception e) {
            log.error("Ошибка при добавлении: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Query query = entityManager.createQuery("delete from Student where id = :studentId");
            query.setParameter("studentId", id);
            int deletedCount = query.executeUpdate();
            if (deletedCount > 0) {
                log.info("Студент удален: ID " + id);
            } else {
                log.info("Студент: ID " + id + " не найден и не был удален");
            }
        } catch (Exception e) {
            log.error("Ошибка при удалении студента: " + e.getMessage(), e);
            throw e;
        }
    }
}