package com.javaweb.api;


import org.springframework.web.bind.annotation.*;

@RestController
public class BuildingAPI {
    @GetMapping(value="/api/building/")
    public void building(@RequestParam(name = "name") String name) {
        System.out.println(name);
    }
}
