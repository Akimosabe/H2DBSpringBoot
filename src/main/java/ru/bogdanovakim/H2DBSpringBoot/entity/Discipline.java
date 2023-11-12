package ru.bogdanovakim.H2DBSpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "teacher")
    private String teacher;



    public Discipline(){}

    public Discipline(String name, String description) {
        this.name = name;
        this.teacher = description;
    }
}