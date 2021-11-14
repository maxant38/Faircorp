package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)

public class RoomController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;


    public RoomController (RoomDao roomDao, BuildingDao buildingDao){

        this.roomDao=roomDao;
        this.buildingDao=buildingDao;
    }
    // get all rooms
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }
    // get room by id
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }
    //delete room by id
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    //Switch the status of the windows in a room specified by id
    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchWindow(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Window window:room.getWindows())
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);

        return new RoomDto(room);
    }
    //Switch the status of the heaters speccified by id
    @PutMapping(path = "/{id}/switchHeater")
    public RoomDto switchHeater(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Heater heater:room.getHeaters())
            heater.setStatus(heater.getStatus() == Status.ON ? Status.OFF: Status.ON);

        return new RoomDto(room);
    }

    //Create room
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Room room = null;
        Building building = buildingDao.getById(dto.getBuilding().getId());
        room = roomDao.save(new Room(building, dto.getName(), dto.getCurrent_temperature(), dto.getTarget_temperature(), dto.getFloor()));

        return new RoomDto(room);
    }

    //Update a room target temperature
    @PutMapping(path = "/{id}")
    public RoomDto updateTargetTemperature(@PathVariable Long id, @RequestBody RoomDto dto) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        room.setTarget_temperature(dto.getTarget_temperature());

        return new RoomDto(room);
    }
    }
