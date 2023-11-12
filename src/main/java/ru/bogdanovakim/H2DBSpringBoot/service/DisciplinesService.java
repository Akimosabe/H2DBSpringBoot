package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import java.util.List;

@Service
public interface DisciplinesService {
    List<Discipline> showAllDisciplines();

    Discipline saveDisciplines(Discipline discipline);

    Discipline getDisciplines(int id);

    void deleteDisciplines(int id);
}