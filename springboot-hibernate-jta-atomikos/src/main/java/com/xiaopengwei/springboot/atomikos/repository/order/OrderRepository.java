package com.xiaopengwei.springboot.atomikos.repository.order;

import com.xiaopengwei.springboot.atomikos.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
