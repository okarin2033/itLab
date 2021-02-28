package ru.mirea.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mirea.shop.api.ApiWork;
import ru.mirea.shop.model.Shop;
import ru.mirea.shop.repos.ShopRepos;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
ShopRepos shopRepos;
    @PostMapping("/")
        public Object addShop(@RequestBody String Json) throws JsonProcessingException {
        Shop shop= new ObjectMapper().readValue(Json, Shop.class);
        shopRepos.save(shop);
        return shop.getName();
    }
    @GetMapping("/{shop}")
        public Shop getShop(@PathVariable String shopName){
        return shopRepos.getShopByName(shopName);
    }

}
