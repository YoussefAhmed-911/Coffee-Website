package com.project.shopping.website.controller;

import com.project.shopping.website.entity.User;
import com.project.shopping.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/v1")
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping("/all")
   public List<User> getAllUsers(){
      return userService.getAllUsers();
   }

   @GetMapping("/getByName/{name}")
   public List<User> getUserByName(@PathVariable String name){

      return userService.getUserByName(name);
   }

   @GetMapping("/getByNameAndEmail/{name}/{email}")
   public User getUserByNameAndEmail(@PathVariable String name,@PathVariable String email){
      return userService.getUserByNameAndEmail(name, email);
   }

   @PostMapping("/add")
   public User createNewUser(@RequestBody User newUser){
      return userService.createNewUser(newUser);
   }

   @DeleteMapping("/del/{userId}")
   public boolean deleteUser(@PathVariable long userId){
      return userService.deleteUserById(userId);

   }
}
