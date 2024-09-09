package com.javaweb.repository;

import com.javaweb.repository.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findALL(String name, Long districtId);
}
