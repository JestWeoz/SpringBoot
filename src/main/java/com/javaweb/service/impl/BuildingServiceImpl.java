package com.javaweb.service.impl;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.imp.BuildingRepositoryImpl;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<BuildingDTO> findAll(String name, Long districtId) {
        List<BuildingEntity> buildingEntities = buildingRepository.findALL(name, districtId);
        List<BuildingDTO> buildingDTOS = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(item.getName());
            buildingDTO.setAddress(item.getStreet() + ", " + item.getWard() + ", " + "districtId = " + item.getDistrictId());
            buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
            buildingDTOS.add(buildingDTO);
        }
        return buildingDTOS;
    }
}
