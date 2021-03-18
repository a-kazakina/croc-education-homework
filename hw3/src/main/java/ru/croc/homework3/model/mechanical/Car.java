package ru.croc.homework3.model.mechanical;

import ru.croc.homework3.model.characteristics.EngineType;
import ru.croc.homework3.model.mechanical.MechanicalLandTransport;

/**
 * Автомобиль.
 */
public class Car extends MechanicalLandTransport {

    /** Поколение автомобиля. */
    private int generation;

    /** Количество пассажирских мест. */
    private int kolSeats;

    /**
     * Конструктор объекта Автомобиль.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param brand брэнд
     * @param enginePower мощность двигателя
     * @param engine тип двигателя
     * @param generation поколение
     * @param kolSeats количество пассажирских мест
     */
    public Car(String number, int rentPrice, String brand, int enginePower, EngineType engine,
               int generation, int kolSeats) {
        super(number, rentPrice, brand, enginePower, engine);
        this.generation = generation;
        this.kolSeats = kolSeats;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getKolSeats() {
        return kolSeats;
    }

    public void setKolSeats(int kolSeats) {
        this.kolSeats = kolSeats;
    }
}
