package ru.mirea.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.shop.api.ApiWork;
@RestController
@RequestMapping("/shop")
public class ShopController {

    @GetMapping("/")
        public String testMethod(){
        return ApiWork.getMethod("user/Okarin");
    }

}
