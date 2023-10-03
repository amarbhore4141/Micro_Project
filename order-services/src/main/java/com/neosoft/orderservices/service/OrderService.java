package com.neosoft.orderservices.service;

import com.neosoft.orderservices.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
