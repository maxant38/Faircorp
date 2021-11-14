package com.emse.spring.faircorp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.Set;



@Entity //indicates that this class is an entity managed by hibernate
@Table(name = "ROOM")

public class Room {
    //attributes

    @Id // (3).
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=255)  // (4).
    private String name;


    private Double current_temperature;
    @Column(nullable = false)
    private int floor;
    private Double target_temperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    @ManyToOne
    private Building building;


    //Constructors


    public Room(Building building,String name, Double current_temperature, Double target_temperature, Set<Heater> heaters, Set<Window> windows) {
        this.name = name;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.heaters = heaters;
        this.windows = windows;
        this.building=building;
    }

    public Room(Building building,String name, Double current_temperature, Double target_temperature, int floor) {
        this.name = name;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.building=building;
        this.floor=floor;
    }

    public  Room (){}

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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
