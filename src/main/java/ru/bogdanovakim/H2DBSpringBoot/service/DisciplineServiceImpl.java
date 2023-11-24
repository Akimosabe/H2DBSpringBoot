package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.dao.DisciplineDAO;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public boolean deleteDiscipline(int id) {
        disciplineDAO.deleteDiscipline(id);
        return false;
    }
}