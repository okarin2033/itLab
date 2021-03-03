package ru.mirea.shop.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.shop.api.ApiWork;
import ru.mirea.shop.model.Good;
import ru.mirea.shop.model.Shop;
import ru.mirea.shop.repos.GoodRepos;
import ru.mirea.shop.repos.ShopRepos;

@RestController
@RequestMapping("/shop")
public class BuyController {
@Autowired
    ShopRepos shopRepos;
@Autowired
    GoodRepos goodRepos;
    @PostMapping("/{shopName}/buy")
    public Object buyGood(@RequestBody String json, @PathVariable String shopName){
        JsonObject object= JsonParser.parseString(json).getAsJsonObject();
        String userName=object.get("name").getAsString();
        String goodName=object.get("good").getAsString();
        int amount = object.get("amount").getAsInt();
        Shop shop = shopRepos.getShopByName(shopName);
        String date=java.time.LocalDate.now().toString();
        System.out.println(shop);
        JsonObject jsonToPut=new JsonObject();
        jsonToPut.addProperty("date",date);

       for(Good good: shop.getGoodList()){
           if (good.getName().equals(goodName)) {
               System.out.println("HelloWorld");
               good.setAmount(good.getAmount()-amount);
               goodRepos.save(good);
               jsonToPut.addProperty("name", goodName);
               jsonToPut.addProperty("sum", good.getCost());
               return(ApiWork.postMethod("user/" + userName + "/purchases", jsonToPut.toString()));
           }
       }
        return null;
    }
}
