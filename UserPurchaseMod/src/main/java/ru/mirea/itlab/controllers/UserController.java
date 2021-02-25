package ru.mirea.itlab.controllers;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.itlab.apiRes.errors.FindError;
import ru.mirea.itlab.apiRes.errors.JsonError;
import ru.mirea.itlab.apiRes.errors.UpdateError;
import ru.mirea.itlab.apiRes.succesAlerts.DeleteSucc;
import ru.mirea.itlab.model.Purchase;
import ru.mirea.itlab.model.Users;
import ru.mirea.itlab.repos.PurchaseRepo;
import ru.mirea.itlab.repos.UsersRepo;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    PurchaseRepo purchaseRepo;


    @PutMapping("/{name}")
    public Object updateUser(@RequestBody String Json,
                             @PathVariable("name") String name){
        Iterable<Users> usersIterable = usersRepo.findAll();
        JsonObject userUpdateData=  JsonParser.parseString(Json).getAsJsonObject();
        for (Users user : usersIterable) {
            if (user.getName().equals(name)) {
                try {
                    user.setName(userUpdateData.get("name").getAsString());
                } catch (Exception e) {
                    System.out.println("no name");
                }
                try {
                    user.setBalance(userUpdateData.get("balance").getAsInt());
                } catch (Exception e) {
                    System.out.println("no balance");
                }
            usersRepo.save(user);
                return user;
            }
        }
        return new UpdateError();
    }

    @PostMapping("/")
    public Object addUser(@RequestBody String Json) {
        JsonObject userObject=JsonParser.parseString(Json).getAsJsonObject();
        Users user = new Users();
        user.setName(userObject.get("name").getAsString());
        user.setBalance(userObject.get("balance").getAsInt());
        usersRepo.save(user);
        return user;
    }

    @DeleteMapping("/{name}")
    public Object deleteUser(@PathVariable("name") String name) {
        usersRepo.deleteUsersByName(name);
        return new DeleteSucc(name);
    }

/*    @PutMapping("/")
    public Object updateUser(){
    }*/

    @GetMapping("/{name}")
    public Object getUser(@PathVariable String name) {
        Iterable<Users> usersIterable = usersRepo.findAll();
        for (Users user : usersIterable) {
            if (user.getName().equals(name))
                return user;
        }
        return new FindError();
    }

    @GetMapping("/{name}/purchases")
    public Object getPurchase(@PathVariable String name) {
        Iterable<Users> usersIterable = usersRepo.findAll();
        for (Users user : usersIterable) {
            if (user.getName().equals(name))
                return user.getPurchasesList();
        }
        return new FindError();
    }

    @PostMapping("/{name}/purchases")
    public Object addPurchase(@RequestBody String Json,
                            @PathVariable("name") String name) {
        Purchase purchase = new Purchase();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonObject jsonObject = JsonParser.parseString(Json).getAsJsonObject();
        Users user = usersRepo.getUsersByName(name).get(0);
        purchase.setDate(jsonObject.get("date").getAsString());
        purchase.setName(jsonObject.get("name").getAsString());
        purchase.setSum(jsonObject.get("sum").getAsInt());
        purchaseRepo.save(purchase);
        user.getPurchasesList().add(purchase);
        usersRepo.save(user);
        return user;

    }

    @DeleteMapping("/{userName}/purchases/{id}")
    public Object deletePurchase(@PathVariable("id") long id,
                                 @PathVariable("userName") String userName) {
        Users user;
            if (usersRepo.getUsersByName(userName)!=null)
                user= usersRepo.getUsersByName(userName).get(0);
            else return new FindError();

        Purchase purchase=purchaseRepo.getOne(id);
                user.getPurchasesList().remove(purchase);
                purchaseRepo.delete(purchase);
                usersRepo.save(user);
                purchaseRepo.delete(purchase);
            return new DeleteSucc(purchase.getName());
        }

}
