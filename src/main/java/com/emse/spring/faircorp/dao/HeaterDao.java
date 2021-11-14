package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    @Query("select c from Heater c where c.id=:id")  // (2)
    Heater getById(@Param("id") Long id);

    @Modifying // (3)
    @Query("delete from Heater c where room_id=:room_id")
    void deleteByRoom(long room_id);

}