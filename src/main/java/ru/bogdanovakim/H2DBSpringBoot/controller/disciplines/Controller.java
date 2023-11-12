package ru.bogdanovakim.H2DBSpringBoot.controller.disciplines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bogdanovakim.H2DBSpringBoot.entity.Discipline;
import ru.bogdanovakim.H2DBSpringBoot.service.DisciplinesService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private DisciplinesService disciplinesService;

    @GetMapping("/disciplines")
    public List<Discipline> showAllDisciplines(){
        List<Discipline> allDisciplines = disciplinesService.showAllDisciplines();
        return allDisciplines;
    }

    @GetMapping("/disciplines/{id}")
    public Discipline getDisciplines(@PathVariable("id") int id) {
        return disciplinesService.getDisciplines(id);
    }

    @PostMapping("/disciplines")
    public String saveDisciplines(@RequestBody Discipline disciplines) {
        disciplinesService.saveDisciplines(disciplines);
        return "add disciplines success";
    }

    @PutMapping("/disciplines")
    public String updateDisciplines(@RequestBody Discipline disciplines) {
        disciplinesService.saveDisciplines(disciplines);
        return "update disciplines success";
    }

    @DeleteMapping("/disciplines/{id}")
    public void deleteDisciplines(@PathVariable("id") int id) {
        disciplinesService.deleteDisciplines(id);
    }
}