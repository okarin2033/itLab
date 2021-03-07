package ru.mirea.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int ts;
    int sum;
    String date;
@OneToOne
Good good;
public Receipt(int summ, Good good, String date){
    this.date=date;
    this.good=good;
    this.sum=summ;
}

}
