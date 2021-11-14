package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDao extends JpaRepository<Building, Long> {
    //Find all windows from a building specified by an id
    @Query("select w from Window w where w.room.id in (select r from Room r where r.building.id=:id )")
    List<Window> findWindowsFromBuilding(@Param("id") Long id);

    //Find all heaters from a building specified by an id
    @Query("select h from Heater h where h.room.id in (select r from Room r where r.building.id=:id )")
    List<Heater> findHeatersFromBuilding(@Param("id") Long id);
}
