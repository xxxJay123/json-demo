package com.example.jsondemo.entity;

import com.example.jsondemo.entity.embed.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

/*
 * { "id": 1, "name": "Leanne Graham", "username": "Bret", "email": "Sincere@april.biz", "address": { "street": "Kulas Light", "suite": "Apt. 556", "city": "Gwenborough", "zipcode": "92998-3874",
 * "geo": { "lat": "-37.3159", "lng": "81.1496" } }, "phone": "1-770-736-8031 x56442", "website": "hildegard.org", "company": { "name": "Romaguera-Crona", "catchPhrase":
 * "Multi-layered client-server neural-net", "bs": "harness real-time e-markets" } },
 */

@Getter
@Setter
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id") // Define the column name for the 'id' field
  private Integer id;

  @Column(name = "full_name") // Define the column name for the 'name' field
  private String name;

  @Column(name = "user_name") // Define the column name for the 'username' field
  private String username;

  @Column(name = "user_email") // Define the column name for the 'email' field
  private String email;

  @Embedded
  private Address address; // Embed the Address class

  @Column(name = "user_phone") // Define the column name for the 'phone' field
  private String phone;

  @Column(name = "user_website") // Define the column name for the 'website' field
  private String website;

  @Embedded
  private Company company;


}
