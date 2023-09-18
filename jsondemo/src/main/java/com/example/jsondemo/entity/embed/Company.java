package com.example.jsondemo.entity.embed;
// "company": {
// "name": "Romaguera-Crona",
// "catchPhrase": "Multi-layered client-server neural-net",
// "bs": "harness real-time e-markets"
// }

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Company {

  private String name;
  private String catchPhrase;
  private String bs; // bs stands for business sicne it is the name of the company's business.

}
