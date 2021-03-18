package ru.croc.homework3.model.mechanical;

import ru.croc.homework3.model.Transport;
import ru.croc.homework3.model.characteristics.EngineType;

import java.util.Random;

/**
 * Механический наземный транспорт.
 */
public class MechanicalLandTransport extends Transport {

    /** Брэнд. */
    private final String brand;

    /** Мощность двигателя. */
    private int enginePower;

    /** Тип двигателя. */
    private final EngineType engine;

    public MechanicalLandTransport(String number, int rentPrice, String brand, int enginePower, EngineType engine) {
        super(number, rentPrice);
        this.brand = brand;
        this.enginePower = enginePower;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public EngineType getEngine() {
        return engine;
    }

    @Override
    public String inspection(String detal) {
        return "Результат осмотра механического наземного транспорта (" + brand + "): ТС действительно повреждено. Место поломки: " + detal +
                ". Требуется ремонт в соответствии с техническими особенностями средства.";
    }

    @Override
    public String repairPart() {
        Random randomno = new Random();
        boolean value = randomno.nextBoolean();
        super.isWork(value);
        return "Результат ремонта: " + value;
    }
}
