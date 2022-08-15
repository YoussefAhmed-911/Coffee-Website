package com.project.shopping.website.repository;

import com.project.shopping.website.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   public List<User> findAllByUsername(String username);
   public User findByUsernameAndEmail(String username, String email);


}
