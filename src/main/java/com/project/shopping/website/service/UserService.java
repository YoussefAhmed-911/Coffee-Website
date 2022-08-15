package com.project.shopping.website.service;

import com.project.shopping.website.entity.User;
import com.project.shopping.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   public List<User> getAllUsers(){

      return (List<User>) userRepository.findAll();
   }

   public User createNewUser(User newUser) {
      if(newUser!=null){
        return userRepository.save(newUser);
      }
      return null;
   }

   public boolean deleteUserById(Long userId) {
      if(userId != null){
         userRepository.deleteById(userId);
            return true;
      }
      return false;
      }

   public List<User> getUserByName(String name) {

      return userRepository.findAllByUsername(name);
   }

   public User getUserByNameAndEmail(String name, String email) {
      return userRepository.findByUsernameAndEmail(name,email);
   }
}

