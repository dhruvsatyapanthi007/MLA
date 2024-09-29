package com.mla.order_service.controller;

import com.mla.order_service.dto.OrderRequest;
import com.mla.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {

        try {
            orderService.placeOrder(orderRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body("Order Placed Successfully");
        } catch (NullPointerException nullPointerException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty Order");
        }
    }
}
