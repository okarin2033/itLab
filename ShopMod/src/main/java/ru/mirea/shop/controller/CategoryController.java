package ru.mirea.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.shop.model.Category;
import ru.mirea.shop.repos.CategoryRepos;

@RestController
@RequestMapping("/shop/category")
public class CategoryController {
    @Autowired
    CategoryRepos categoryRepos;
    @PostMapping("/{nameCat}")
    public void addCategory(@PathVariable String nameCat){
        categoryRepos.save(new Category(nameCat));
    }
    @GetMapping("/{nameCat}")
    public Category getCategory(@PathVariable String nameCat){
        return categoryRepos.getByName(nameCat);
    }
}
