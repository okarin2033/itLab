package ru.mirea.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.shop.api.ApiWork;
import ru.mirea.shop.model.Good;
import ru.mirea.shop.model.Shop;
import ru.mirea.shop.repos.CategoryRepos;
import ru.mirea.shop.repos.GoodRepos;
import ru.mirea.shop.repos.ShopRepos;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
ShopRepos shopRepos;
    @Autowired
GoodRepos goodRepos;
    @Autowired
CategoryRepos categoryRepos;
    @PostMapping("/")
        public Object addShop(@RequestBody String Json) throws JsonProcessingException {
        JsonObject shopObj= JsonParser.parseString(Json).getAsJsonObject();
        Shop shop=new Shop();
        shop.setName(shopObj.get("name").getAsString());
        shopRepos.save(shop);
        return shop;
    }
    @GetMapping("/{shop}")
        public Shop getShop(@PathVariable String shop){
        return shopRepos.getShopByName(shop);
    }

    @DeleteMapping("/{shop}")
        public String deleteShop(@PathVariable String shop){
        shopRepos.deleteShopByName(shop);
        return("    {\n" +
                "        \"deleted\": \"Success\"\n" +
                "    }\n");
    }
    @GetMapping("/{shop}/rec")
        public Object getRec(@PathVariable String shop){
        return shopRepos.getShopByName(shop).getCheckList();
    }
    @GetMapping("/{shop}/store")
    public Object getGoods(@PathVariable String shop){
        return shopRepos.getShopByName(shop).getGoodList();
    }
    @PostMapping("/{shop}/store")
    public Object addGood(@PathVariable String shop, @RequestBody String goodObjStr){
        Good good=new Good();
        JsonObject goodObj =JsonParser.parseString(goodObjStr).getAsJsonObject();
        good.setAmount(goodObj.get("amount").getAsInt());
        good.setCost(goodObj.get("cost").getAsInt());
        good.setName(goodObj.get("name").getAsString());
        if (categoryRepos.existsByName(goodObj.get("category").getAsString()))
            good.setCategory(categoryRepos.getByName(goodObj.get("category").getAsString()));
        else return "{\n" +
                "        \"error\": \"CategoryNotFound\"\n" +
                "    }";
        goodRepos.save(good);
        Shop shop1=shopRepos.getShopByName(shop);
        shop1.getGoodList().add(good);
        shopRepos.save(shop1);
        return shop1;
    }

}