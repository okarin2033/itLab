package ru.mirea.itlab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String date;

    private String name;


    private int sum;

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    @Override
    public String toString(){
        return id+"_"+name+"_"+date+"_"+sum;
    }
}
