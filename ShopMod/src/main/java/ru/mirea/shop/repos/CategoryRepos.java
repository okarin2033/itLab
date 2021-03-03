package ru.mirea.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.shop.model.Category;

public interface CategoryRepos extends JpaRepository <Category, Long>{
    public Category getByName(String name);
    public boolean existsByName(String name);
}
