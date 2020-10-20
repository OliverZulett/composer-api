package com.milankascomposer.composerapi.controller;

import com.milankascomposer.composerapi.service.OrderClientService;
import com.milankascomposer.composerapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Object getOrdersByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
        return this.orderClientService.getOrdersByUserId(userId);
    }

}
