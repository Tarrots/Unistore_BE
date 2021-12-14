package com.unistore.server.controllers;

import com.unistore.server.common.JwtUtils;
import com.unistore.server.dto.OrderRequest;
import com.unistore.server.models.OrderDetail;
import com.unistore.server.models.ResponseObject;
import com.unistore.server.models.User;
import com.unistore.server.repositories.OrderDetailRepository;
import com.unistore.server.repositories.OrderRepository;
import com.unistore.server.repositories.ProductRepository;
import com.unistore.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addOrder(@Validated @RequestHeader String Authorization, @RequestBody OrderRequest orderRequest) {
        String token = Authorization.substring(7, Authorization.length());
        String username = jwtUtils.getUsernameFromJwtToken(token);

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Not found user")
        );

//        orderRequest.getProduct().stream().map(
//                productQuantity -> {
//                    OrderDetail orderDetail = new OrderDetail();
//                }
//        );
        //Object[] arr = orderRequest.getProduct().toArray();
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "test", orderRequest.getProduct())
        );
    }
}
