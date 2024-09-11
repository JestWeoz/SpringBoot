package com.javaweb.api;


import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @GetMapping(value="/api/building/")
    public List<BuildingDTO> building(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "districtid") Long districtid) {
        List<BuildingDTO> ds = buildingService.findAll(name, districtid);
        return ds;
    }
}
