package com.project.shopping.website.service;

import com.project.shopping.website.dto.ProductDto;
import com.project.shopping.website.entity.Category;
import com.project.shopping.website.entity.Product;
import com.project.shopping.website.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

   @Autowired
   ProductRepo productRepo;

   @Autowired
   CategoryService categoryService;

   public void createProduct(ProductDto productDto, Category category) {
      Product product = new Product();
      product.setDescription(productDto.getDescription());
      product.setImageUrl(productDto.getImageUrl());
      product.setName(productDto.getName());
      product.setPrice(productDto.getPrice());
      product.setId(productDto.getId());
      product.setCategory(category);
      productRepo.save(product);
   }

   public ProductDto getProductDto(Product product){
      ProductDto productDto = new ProductDto();
      productDto.setDescription(product.getDescription());
      productDto.setImageUrl(product.getImageUrl());
      productDto.setName(product.getName());
      productDto.setPrice(product.getPrice());
      productDto.setId(product.getId());
      productDto.setCategoryId(product.getCategory().getId());
      return productDto;
   }
   public List<ProductDto> getAllProducts() {

     //Optional<Category> category = categoryService.findById(catId);
     List<Product> allProducts =  productRepo.findAll();

     List<ProductDto> productDtos = new ArrayList<>();
     for(Product product: allProducts){
         productDtos.add(getProductDto(product));
     }
     return productDtos;
   }

   public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
      Optional<Product> optionalProduct = productRepo.findById(productId);

      if(!optionalProduct.isPresent()){
         throw new Exception("product not present");
      }
      Product product = optionalProduct.get();
      product.setDescription(productDto.getDescription());
      product.setImageUrl(productDto.getImageUrl());
      product.setName(productDto.getName());
      product.setPrice(productDto.getPrice());
      product.setId(productDto.getId());
      productRepo.save(product);

   }

   public boolean deleteProductById(Integer productId) {
      if(productId != null){
         productRepo.deleteById(productId);
         return true;
      }
      return false;
   }
}
