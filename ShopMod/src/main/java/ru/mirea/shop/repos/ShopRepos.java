package ru.mirea.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.shop.model.Shop;

public interface ShopRepos extends JpaRepository<Shop, Long> {
    public Shop getShopByName(String name);
}
