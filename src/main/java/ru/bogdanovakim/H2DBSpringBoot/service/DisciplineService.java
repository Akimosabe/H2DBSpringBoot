package ru.bogdanovakim.H2DBSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline getDiscipline(int id);
    Discipline saveDiscipline(Discipline discipline);
    boolean deleteDiscipline(int id);
}