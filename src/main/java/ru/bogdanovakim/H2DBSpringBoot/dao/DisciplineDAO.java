package ru.bogdanovakim.H2DBSpringBoot.dao;
import org.springframework.stereotype.Repository;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    void deleteDiscipline(int id);
}