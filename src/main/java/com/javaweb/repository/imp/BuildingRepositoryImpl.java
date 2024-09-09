package com.javaweb.repository.imp;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";

    @Override
    public List<BuildingEntity> findALL(String name, Long districtId) {
        StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
        if (name != null && !name.isEmpty() && districtId != null) {
            sql.append(" and b.name like '%" + name + "%'");
        }
        if (districtId != null) {
            sql.append(" and b.districtId = " + districtId);
        }
        List<BuildingEntity> results = new ArrayList<BuildingEntity>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                BuildingEntity dto = new BuildingEntity();
                dto.setName(rs.getString("name"));
                dto.setWard(rs.getString("ward"));
                dto.setStreet(rs.getString("street"));
                dto.setNumberOfBasement(rs.getInt("numberOfBasement"));
                dto.setDistrictId(rs.getLong("districtId"));
                results.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected database failed...");
        }
        return results;
    }
}
