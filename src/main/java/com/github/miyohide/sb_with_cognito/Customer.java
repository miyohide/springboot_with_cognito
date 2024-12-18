package com.github.miyohide.sb_with_cognito;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Setter
@Getter
@Table
public class Customer {
  @Id
  private Integer id;

  private String name;
  private String address;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address);
  }
}
