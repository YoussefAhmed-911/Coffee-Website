package com.project.shopping.website.repository;

import com.project.shopping.website.entity.Product;
import com.project.shopping.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


}
