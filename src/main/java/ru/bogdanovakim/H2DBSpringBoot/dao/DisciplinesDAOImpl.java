package ru.bogdanovakim.H2DBSpringBoot.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Slf4j
public class DisciplinesDAOImpl implements ServiceDisciplinesDAO {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Discipline> showAllDisciplines() {
        Query query = entityManager.createQuery("from AcademicDisciplines");
        List<Discipline> showAllDisciplines = query.getResultList();
        log.info("allDisciplines", showAllDisciplines);
        return showAllDisciplines;
    }

    @Override
    public Discipline getDisciplines(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public Discipline saveDisciplines(Discipline disciplines) {
        return entityManager.merge(disciplines);
    }

    @Override
    public void deleteDisciplines(int id) {
        Query query = entityManager.createQuery("delete from AcademicDisciplines " +
                "where id =: disciplinesId");
        query.setParameter("disciplinesId", id);
        query.executeUpdate();
    }
}