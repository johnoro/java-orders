package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  @Query(
    value = "SELECT c.*" +
      " FROM customers c, agents a" +
      " WHERE a.agentcode = c.agentcode",
    nativeQuery = true
  )
  List<Customer> agentCustomers();

  Customer findByName(String name);
}
