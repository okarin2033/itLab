package ru.mirea.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Good {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
int name;
int cost;
//@ManyToOne
//Category category;
}
