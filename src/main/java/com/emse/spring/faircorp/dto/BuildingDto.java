package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.Set;

public class BuildingDto {
    private Long id;
    private String name;
    private Set<Room> rooms;

    //Constructors
    public BuildingDto() {
    }

    public BuildingDto (Building building){
        this.id=building.getId();
        this.name=building.getName();
        this.rooms=building.getRooms();
    }
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
