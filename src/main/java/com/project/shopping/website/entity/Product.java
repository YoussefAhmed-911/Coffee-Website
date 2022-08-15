package com.project.shopping.website.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "products")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "prod_id")
   private Integer id;
   @Column(name = "prod_name", nullable = false)
   private String name;
   @Column(name = "prod_imageUrl", nullable = false)
   private String imageUrl;
   @Column(name = "prod_price", nullable = false)
   private double price;
   @Column(name = "prod_description", nullable = false)
   private String description;

   @JoinColumn(name = "category_id")
   @ManyToOne
   private Category category;
}
