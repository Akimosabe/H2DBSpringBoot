package ru.bogdanovakim.H2DBSpringBoot.controller.disciplines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;
import ru.bogdanovakim.H2DBSpringBoot.service.DisciplineService;

import java.util.List;



@RestController
@RequestMapping("/api/")
public class AdditionalController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<List<Discipline>> showAllDisciplines() {
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        if (!allDisciplines.isEmpty()) {
            return new ResponseEntity<>(allDisciplines, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline != null) {
            return new ResponseEntity<>(discipline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/disciplines")
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        Discipline savedDiscipline = disciplineService.saveDiscipline(discipline);
        if (savedDiscipline != null) {
            return new ResponseEntity<>(savedDiscipline, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("disciplines/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
        if (updatedDiscipline != null) {
            return new ResponseEntity<>(updatedDiscipline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable("id") int id) {
        boolean deleted = disciplineService.deleteDiscipline(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}