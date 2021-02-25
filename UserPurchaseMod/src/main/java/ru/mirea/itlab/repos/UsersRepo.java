package ru.mirea.itlab.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.mirea.itlab.model.Users;

import java.util.List;

public interface UsersRepo extends JpaRepository<Users, Long> {
    public List<Users> getUsersByName(String name);
    public void deleteUsersByName(String name);
}
