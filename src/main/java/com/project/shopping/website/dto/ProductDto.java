package com.project.shopping.website.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {


   private Integer id;

   private @NotNull String name;

   private @NotNull String imageUrl;

   private @NotNull double price;

   private @NotNull String description;

   private @NotNull Integer categoryId;
}
