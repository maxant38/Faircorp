package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/buildings")
@Transactional

public class BuildingController {
    private final BuildingDao buildingDao;
    //Constructor
    public BuildingController(BuildingDao buildingDao){ this.buildingDao=buildingDao; }

    //Get all buildings
    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    //Get a building by id
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    //Delete a building
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }

    //Create  a building
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {

        Building building = null;
        building = buildingDao.save(new Building(dto.getName()));

        return new BuildingDto(building);

    }
    //find rooms in a building identified with its id
    @GetMapping(path="/{id}/rooms")
    public List<RoomDto> findAllBuildingRooms(@PathVariable Long id) {
        List<Room> rooms= buildingDao.findBuildingRooms(id);
        return rooms.stream().map(RoomDto::new).collect(Collectors.toList());
    }
}



