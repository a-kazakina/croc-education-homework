package ru.croc.homework3.model.air;

import ru.croc.homework3.model.characteristics.ModelAirTransport;

/**
 * Вертолет.
 */
public class Helicopter extends AirTransport {

    /** Максимальная скорость. */
    private int maxSpeed;

    /** Объем топливного бака. */
    private int fuelTankVolume;

    /**
     * Конструктор объекта Вертолет.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param model модель
     * @param carryingCapacity грузоподъемность
     * @param maxSpeed максимальная скорость
     * @param fuelTankVolume объем топливного бака
     */
    public Helicopter(String number, int rentPrice, ModelAirTransport model, int carryingCapacity,
                      int maxSpeed, int fuelTankVolume) {
        super(number, rentPrice, model, carryingCapacity);
        this.maxSpeed = maxSpeed;
        this.fuelTankVolume = fuelTankVolume;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(int fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }
}
