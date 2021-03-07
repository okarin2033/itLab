package ru.mirea.shop.model;

import lombok.*;
import org.hibernate.annotations.Generated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shop {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
int id;
String name;
@OneToMany
List<Receipt> checkList;
@OneToMany
List<Good> goodList;

public void addRec(Receipt rec){
    checkList.add(rec);
}

}
