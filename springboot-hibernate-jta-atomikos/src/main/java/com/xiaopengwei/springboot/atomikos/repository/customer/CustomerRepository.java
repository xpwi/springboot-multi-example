package com.xiaopengwei.springboot.atomikos.repository.customer;

import com.xiaopengwei.springboot.atomikos.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
