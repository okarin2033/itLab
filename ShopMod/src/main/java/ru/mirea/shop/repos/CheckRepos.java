package ru.mirea.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.shop.model.Receipt;

public interface CheckRepos extends JpaRepository<Receipt, Long> {
}
