package com.emse.spring.faircorp.api;



import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/heaters") // (2)
@Transactional // (3)

public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    //Constructor
    public HeaterController(HeaterDao heaterDao, RoomDao roomDao){
        this.heaterDao=heaterDao;
        this.roomDao = roomDao;
    }
    //find all heaters
    @GetMapping // (5)
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }
    //find a heater by id
    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }
    //delete a heater by id
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }

    //Switch the status of a heater
    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setStatus(heater.getStatus() == Status.ON ? Status.OFF : Status.ON);
        return new HeaterDto(heater);
    }

    //Create or modify a heater
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the window room
        Room room = roomDao.getById(dto.getId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), room, dto.getHeater_status()));
        } else {
            heater = heaterDao.getById(dto.getId());
            heater.setStatus(dto.getHeater_status());
        }
        return new HeaterDto(heater);
    }
    }


