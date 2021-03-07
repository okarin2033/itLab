package ru.factory.mod.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToMany
    List<Good> goodList=new ArrayList<>();
    int power;
}
