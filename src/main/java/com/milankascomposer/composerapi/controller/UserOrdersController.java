package com.milankascomposer.composerapi.controller;

import com.milankascomposer.composerapi.dto.UserDTO;
import com.milankascomposer.composerapi.service.OrderClientService;
import com.milankascomposer.composerapi.service.ProductClientService;
import com.milankascomposer.composerapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("v1")
public class UserOrdersController {

    @Autowired
    UserClientService userClientService;
    @Autowired
    OrderClientService orderClientService;
    @Autowired
    ProductClientService productClientService;

//    @GetMapping("/users/{userId}/orders")
//    @ResponseStatus(value = HttpStatus.OK)
//    @ResponseBody
//    public Mono<List<OrderDTO>> getOrdersByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
//        Mono<UserDTO> userStored = this.userClientService.getUserById(userId);
//        return userStored
//                .flatMap(userDTO -> this.orderClientService.getOrdersByUserId(userDTO.getUserId()));
////        return this.userClientService.getUserById(userId);
////        Mono<UserDTO> userStored = this.userClientService.getUserById(userId);
////        return userStored.flatMap(userDTO -> userDTO.getUserId()).block();
////        return this.userClientService.getUserById(userId)
////                .subscribe(
////                        userDTO -> new ResponseEntity<List<UserDTO>>.ok(this.orderClientService.getOrdersByUserId(userDTO.getUserId())),
////                        error -> System.out.println(error.getMessage()),
////                        () -> System.out.println("Mono consumed.")
////                );
////        UserDTO user = userClientService.getUserById(userId).block();
////        System.out.println(user);
////        List<OrderDTO> orders = this.orderClientService.getOrdersByUserId(user.getUserId()).block();
////        System.out.println(orders);
////        if (orders == null || orders.size() == 0) return null;
////        return orders;
//    }

    @GetMapping("/users/{userId}/products")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public UserDTO getProductsByUserId(@Valid @PathVariable(value = "userId") UUID userId) {

        return this.userClientService.getUserById(userId);
//    public List<Mono<ProductDTO>> getProductsByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
//        Mono<UserDTO> userStored = this.userClientService.getUserById(userId);
//        return userStored
//                .flatMap(userDTO -> {
//                    return this.orderClientService.getOrdersByUserId(userDTO.getUserId())
//                            .flatMap(orderDTOS -> {
//                                List<Mono<ProductDTO>> products = new ArrayList<>();
//                                orderDTOS.forEach(orderDTO -> {
//                                    List<LineItemDTO> lineItemDTOS = orderDTO.getLineItems();
//                                    lineItemDTOS.forEach(lineItemDTO -> {
//                                        products.add(
//                                                this.productClientService.getProductById(lineItemDTO.getProductId())
//                                        );
//                                    });
//                                });
////                                return products;
//                            });
//                });
    }

}
