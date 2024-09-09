package com.javaweb.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingAPI {
    @GetMapping (value = "/api/building/")
    public void building(@RequestParam (value = "name") String name) {
        System.out.println(name);
    }
}
