package ru.croc.homework7.model;

import java.sql.Date;
import java.util.Objects;

/**
 * Животное.
 */
public class Animal {

    /** Код. */
    private Integer id;

    /** Имя. */
    private String name;

    /** Количество конечностей. */
    private Integer limbs;

    /** Дата рождения. */
    private Date dateOfBirth;

    /** Хищник или нет. */
    private Boolean predator;

    /** Номер вольера. */
    private Integer aviaryNumber;

    public Animal(Integer id, String name, Integer limbs, Date dateOfBirth, Boolean predator, Integer aviaryNumber) {
        this.id = id;
        this.name = name;
        this.limbs = limbs;
        this.dateOfBirth = dateOfBirth;
        this.predator = predator;
        this.aviaryNumber = aviaryNumber;
    }

    public Animal () {}

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

    public Integer getLimbs() {
        return limbs;
    }

    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getPredator() {
        return predator;
    }

    public void setPredator(Boolean predator) {
        this.predator = predator;
    }

    public Integer getAviaryNumber() {
        return aviaryNumber;
    }

    public void setAviaryNumber(Integer aviaryNumber) {
        this.aviaryNumber = aviaryNumber;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", limbs=" + limbs +
                ", dateOfBirth=" + dateOfBirth +
                ", predator=" + predator +
                ", aviaryNumber=" + aviaryNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && Objects.equals(limbs, animal.limbs) && Objects.equals(dateOfBirth, animal.dateOfBirth) && Objects.equals(predator, animal.predator) && Objects.equals(aviaryNumber, animal.aviaryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, limbs, dateOfBirth, predator, aviaryNumber);
    }
}
