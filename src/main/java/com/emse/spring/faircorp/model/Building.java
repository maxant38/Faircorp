package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity //indicates that this class is an entity managed by hibernate
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    //constructors
    public Building( String name ){

        this.name = name;

    }
    public Building (){
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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}