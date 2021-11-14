package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Double current_temperature;
    private Double target_temperature;
    private Set<Heater> heaters;
    private Set<Window> windows;

    //Constructors
    public RoomDto(){

    }

    public RoomDto (Room room){
        this.id = room.getId();
        this.name = room.getName();
        this.current_temperature= room.getCurrent_temperature();
        this.target_temperature= room.getTarget_temperature();
        this.heaters=room.getHeaters();
        this.windows=room.getWindows();
    }

    //getters and setters
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

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }
}
