package com.project.shopping.website.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id", nullable = false)
   private Long id;
   @Column(name = "user_name", length = 100, nullable = false)
   private String username;
   @Column(name = "user_email", unique = true)
   private String email;
   @Column(name = "user_pass")
   private String password;

   @JoinColumn(name = "cart_id")
   @OneToOne
   private Cart cart;

}
