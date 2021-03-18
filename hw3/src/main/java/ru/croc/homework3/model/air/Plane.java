package ru.croc.homework3.model.air;

import ru.croc.homework3.model.characteristics.ModelAirTransport;

/**
 * Самолет.
 */
public class Plane extends AirTransport {

    /** Разамах крыльев. */
    private int wingspan;

    /** Максимальное количество пассажиров на борту. */
    private int kolPassengers;

    /**
     * Конструктор объекта Самолет.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param model модель
     * @param carryingCapacity грузоподъемность
     * @param wingspan размах крыльев
     * @param kolPassengers кол-во пассажиров на борту
     */
    public Plane(String number, int rentPrice, ModelAirTransport model, int carryingCapacity,
                 int wingspan, int kolPassengers) {
        super(number, rentPrice, model, carryingCapacity);
        this.wingspan = wingspan;
        this.kolPassengers = kolPassengers;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getKolPassengers() {
        return kolPassengers;
    }

    public void setKolPassengers(int kolPassengers) {
        this.kolPassengers = kolPassengers;
    }
}
