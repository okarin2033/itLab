package ru.mirea.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int sum;
//@OneToMany
//List<Good> goodList;

}
