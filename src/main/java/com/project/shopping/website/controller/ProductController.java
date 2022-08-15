package com.project.shopping.website.controller;

import com.project.shopping.website.common.ApiResponse;
import com.project.shopping.website.dto.ProductDto;
import com.project.shopping.website.entity.Category;
import com.project.shopping.website.entity.Product;
import com.project.shopping.website.repository.CategoryRepo;
import com.project.shopping.website.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
   ProductService productService;
   @Autowired
   CategoryRepo categoryRepo;

   @PostMapping("/add")
   public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
      Optional<Category> optionalCategory= categoryRepo.findById(productDto.getCategoryId());
      if(!optionalCategory.isPresent()){
         return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
      }
      productService.createProduct(productDto,optionalCategory.get());
      return new ResponseEntity<>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
   }

   @GetMapping("/all")
   public ResponseEntity<List<ProductDto>> getProducts(){
       List<ProductDto> products = productService.getAllProducts();
       return new ResponseEntity<>(products,HttpStatus.OK);
   }

   @PostMapping("/update/{productId}")
   public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
      Optional<Category> optionalCategory= categoryRepo.findById(productDto.getCategoryId());
      if(!optionalCategory.isPresent()){
         return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
      }
      productService.updateProduct(productDto, productId);
      return new ResponseEntity<>(new ApiResponse(true,"product has been updated"), HttpStatus.OK);
   }

   @DeleteMapping("/del/{productId}")
   public boolean deleteProductById(@PathVariable Integer productId){
      return productService.deleteProductById(productId);

   }
}
