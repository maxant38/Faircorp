package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDaoCustom {
    @Query("select c from Room c where c.name=:name")  // (2)
    Room findByName(@Param("name") String name);

    List<Room> findName(String name);
    List<Heater> findRoomHeaters(Long id);
    List<Window> findRoomWindows(Long id);


}
