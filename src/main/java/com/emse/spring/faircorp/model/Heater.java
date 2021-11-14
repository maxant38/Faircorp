package com.emse.spring.faircorp.model;


import javax.persistence.*;

@Entity //indicates that this class is an entity managed by hibernate
@Table(name = "HEATER")
public class Heater {
    @Id
    @GeneratedValue
    private Long id;



    @Column(nullable=false, length=255)  // (4).
    private String name;

    @Column(nullable=true)
    private Long power;


    @ManyToOne
    private Room room;

    @Enumerated( EnumType.STRING)
    private Status heater_status;


    //Constructors

    public Heater(){
    }
    public Heater(String name,Room room,Status heater_status){
        this.name=name;
        this.heater_status=heater_status;
        this.room=room;
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

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Status getStatus() {
        return heater_status;
    }

    public void setStatus(Status heater_status) {
        this.heater_status = heater_status;
    }
}
