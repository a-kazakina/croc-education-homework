package ru.croc.homework8.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Time;
import java.util.Objects;

public class MunicipalEnterprise {

    @XmlTransient
    private Integer id;

    @XmlElement()
    private String name;

    @XmlTransient
    private Time timeOpen;

    @XmlTransient
    private Time timeClose;

    @XmlTransient
    private String director;

    @XmlElement (name = "description")
    private String address;

    public MunicipalEnterprise() {}
    public MunicipalEnterprise(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public MunicipalEnterprise(Integer id, String name, Time timeOpen, Time timeClose, String director, String address) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MunicipalEnterprise that = (MunicipalEnterprise) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(timeOpen, that.timeOpen) && Objects.equals(timeClose, that.timeClose) && Objects.equals(director, that.director) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, timeOpen, timeClose, director, address);
    }
}
