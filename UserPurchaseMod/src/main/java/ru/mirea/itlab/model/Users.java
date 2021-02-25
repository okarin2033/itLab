package ru.mirea.itlab.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Purchase> purchasesList;
    private String name;


    private int balance;
    public Users(String name){
        this.name=name;
    }

    public Users() {

    }

    public long getId() {
        return id;
    }

    public List<Purchase> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchase> purchasesList) {
        this.purchasesList = purchasesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addPurchase(Purchase purchase){
        purchasesList.add(purchase);
    }
}
