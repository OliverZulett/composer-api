package com.milankascomposer.composerapi.controller;

import com.milankascomposer.composerapi.dto.OrderDTO;
import com.milankascomposer.composerapi.dto.UserDTO;
import com.milankascomposer.composerapi.service.OrderClientService;
import com.milankascomposer.composerapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1")
public class UserOrdersController {

    @Autowired
    UserClientService userClientService;
    @Autowired
    OrderClientService orderClientService;

    @GetMapping("/users/{userId}/orders")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Mono<List<OrderDTO>> getOrdersByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
        return this.userClientService.getUserById(userId);
//        Mono<UserDTO> userStored = this.userClientService.getUserById(userId);
//        return userStored.flatMap(userDTO -> userDTO.getUserId()).block();
//        return this.userClientService.getUserById(userId)
//                .subscribe(
//                        userDTO -> new ResponseEntity<List<UserDTO>>.ok(this.orderClientService.getOrdersByUserId(userDTO.getUserId())),
//                        error -> System.out.println(error.getMessage()),
//                        () -> System.out.println("Mono consumed.")
//                );
//        UserDTO user = userClientService.getUserById(userId).block();
//        System.out.println(user);
//        List<OrderDTO> orders = this.orderClientService.getOrdersByUserId(user.getUserId()).block();
//        System.out.println(orders);
//        if (orders == null || orders.size() == 0) return null;
//        return orders;
    }

}
