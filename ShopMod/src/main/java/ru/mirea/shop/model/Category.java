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
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String name;

    public Category(String nameCat) {
        this.name=nameCat;
    }
}
