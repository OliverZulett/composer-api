package com.milankascomposer.composerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class HealthCheckController {

    @GetMapping("/healthcheck")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String healthCheck() {
        return "I'm Alive";
    }

}
