package ru.croc.homework3.model.mechanical;

import ru.croc.homework3.model.characteristics.EngineType;
import ru.croc.homework3.model.mechanical.MechanicalLandTransport;

/**
 * Мотоцикл.
 */
public class Motorcycle extends MechanicalLandTransport {

    /** Расход топлива на 100км. */
    private int fuelConsumption;

    /**
     * Конструктор объекта Мотоцикл.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param brand брэнд
     * @param enginePower мощность двигателя
     * @param engine тип двигателя
     * @param fuelConsumption расход топлива
     */
    public Motorcycle(String number, int rentPrice, String brand, int enginePower,
                      EngineType engine, int fuelConsumption) {
        super(number, rentPrice, brand, enginePower, engine);
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
