package ru.croc.homework8.model.in;

import java.sql.Time;

/**
 * Досуговое предприятие.
 */
public class LeisureEnterprise {

    /** Код. */
    private Integer id;

    /** Наименование. */
    private String name;

    /** Время открытия. */
    private Time timeOpen;

    /** Время закрытия. */
    private Time timeClose;

    /** Директор. */
    private String director;

    /** Адрес. */
    private String address;

    public LeisureEnterprise(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public LeisureEnterprise(Integer id, String name, Time timeOpen, Time timeClose, String director, String address) {
        this.id = id;
        this.name = name;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.director = director;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Time timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Time getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Time timeClose) {
        this.timeClose = timeClose;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
