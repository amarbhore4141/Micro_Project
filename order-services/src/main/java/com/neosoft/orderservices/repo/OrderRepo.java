package com.neosoft.orderservices.repo;

import com.neosoft.orderservices.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Long> {
}
