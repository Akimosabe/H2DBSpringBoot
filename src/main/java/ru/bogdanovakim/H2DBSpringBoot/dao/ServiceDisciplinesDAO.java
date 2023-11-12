package ru.bogdanovakim.H2DBSpringBoot.dao;

import org.springframework.stereotype.Repository;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import java.util.List;

@Repository
public interface ServiceDisciplinesDAO {
    List<Discipline> showAllDisciplines();

    Discipline getDisciplines(int id);

    Discipline saveDisciplines(Discipline disciplines);

    void deleteDisciplines(int id);

}