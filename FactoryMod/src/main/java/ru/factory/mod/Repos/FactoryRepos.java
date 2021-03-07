package ru.factory.mod.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.factory.mod.Model.Factory;

public interface FactoryRepos extends JpaRepository<Factory, Long> {
    public boolean deleteById(int id);
}
