package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDaoCustom {
    @Query("select c from Room c where c.name=:name")  // (2)
    Room findByName(@Param("name") String name);
}
