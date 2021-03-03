package ru.mirea.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.shop.model.Good;

public interface GoodRepos extends JpaRepository<Good, Long> {
public Good getGoodByName(String name);
}
