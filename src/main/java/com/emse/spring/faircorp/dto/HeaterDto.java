package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Status;

public class HeaterDto {
    private Long id;
    private String name;
    private Long roomId;
    private Status heater_status;

    public HeaterDto(){

    }
     public HeaterDto(Heater heater){
        this.id=heater.getId();
        this.name=heater.getName();
        this.heater_status=heater.getStatus();
        this.roomId=heater.getRoom().getId();
     }





    //Getters and setters
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

    public Long getRoom() {
        return roomId;
    }

    public void setRoom(Long id) {
        this.roomId = id;
    }

    public Status getHeater_status() {
        return heater_status;
    }

    public void setHeater_status(Status heater_status) {
        this.heater_status = heater_status;
    }
}
