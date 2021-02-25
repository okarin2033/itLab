package ru.mirea.itlab.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.mirea.itlab.model.Purchase;
import ru.mirea.itlab.model.Users;

import java.util.List;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    public List<Purchase> getPurchaseByName(String name);
    public void deletePurchaseById(long id);
}
