package com.milankascomposer.composerapi.controller;

import com.milankascomposer.composerapi.dto.LineItemDTO;
import com.milankascomposer.composerapi.dto.OrderDTO;
import com.milankascomposer.composerapi.dto.ProductDTO;
import com.milankascomposer.composerapi.dto.UserDTO;
import com.milankascomposer.composerapi.service.OrderClientService;
import com.milankascomposer.composerapi.service.ProductClientService;
import com.milankascomposer.composerapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    UserClientService userClientService;
    @Autowired
    OrderClientService orderClientService;
    @Autowired
    ProductClientService productClientService;

    @GetMapping("/{userId}/orders")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<OrderDTO> getOrdersByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
        UserDTO userStored = this.userClientService.getUserById(userId);
        return this.orderClientService.getOrdersByUserId(userStored.getUserId());
    }

    @GetMapping("/{userId}/products")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ProductDTO> getProductsByUserId(@Valid @PathVariable(value = "userId") UUID userId) {
        UserDTO userStored = this.userClientService.getUserById(userId);
        List<LineItemDTO> lineItemsStored = this.orderClientService.getLineItemsFromOrdersByUserId(userStored.getUserId());
        return this.productClientService.getProductsFromLineItemsList(lineItemsStored);
    }

}
