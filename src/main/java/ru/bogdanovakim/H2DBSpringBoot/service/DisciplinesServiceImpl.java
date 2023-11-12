package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.dao.ServiceDisciplinesDAO;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DisciplinesServiceImpl  implements DisciplinesService{
    @Autowired
    private ServiceDisciplinesDAO serviceDisciplinesDAO;
    @Override
    @Transactional
    public List<Discipline> showAllDisciplines() {
        return serviceDisciplinesDAO.showAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDisciplines(Discipline discipline) {
        return serviceDisciplinesDAO.saveDisciplines(discipline);
    }

    @Override
    @Transactional
    public Discipline getDisciplines(int id) {
        return serviceDisciplinesDAO.getDisciplines(id);
    }

    @Override
    @Transactional
    public void deleteDisciplines(int id) {
        serviceDisciplinesDAO.deleteDisciplines(id);
    }
}