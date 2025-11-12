package com.sp.order.controller;

import com.sp.order.entity.Order;
import com.sp.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/orders")
    public List<Order> allOrders(){

        return orderRepo.findAll();
    }

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderRepo.getReferenceById(id);
        }
}
