package ru.mirea.itlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String date;
    private String name;
    private int sum;




    @Override
    public String toString(){
        return id+"_"+name+"_"+date+"_"+sum;
    }
}
