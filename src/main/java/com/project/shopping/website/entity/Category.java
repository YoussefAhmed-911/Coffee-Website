package com.project.shopping.website.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "category")
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "category_id", nullable = false)
   private Integer id;
   @Column(name = "category_name", nullable = false)
   private String categoryName;
   @Column(name = "description", nullable = false)
   private String description;
   @Column(name = "image_url", nullable = false)
   private String imageUrl;


}
