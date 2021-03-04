package ru.mirea.itlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Purchase> purchasesList;
    private String name;

    public Users(String name){
        this.name=name;
    }

    public Users() {

    }

    public void addPurchase(Purchase purchase){
        purchasesList.add(purchase);
    }
}
