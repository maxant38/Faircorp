package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDaoCustom {
    //Find all rooms from a building specified by an id
    List<Room> findBuildingRooms(@Param("id") Long id);
}
