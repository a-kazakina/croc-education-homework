package ru.croc.homework3.model.air;

import ru.croc.homework3.model.Transport;
import ru.croc.homework3.model.characteristics.EngineType;
import ru.croc.homework3.model.characteristics.ModelAirTransport;

import java.util.Random;

import static ru.croc.homework3.model.characteristics.EngineType.JET;

/**
 * Воздушный транспорт.
 */
public class AirTransport extends Transport {

    /** Модель транспорта. */
    private ModelAirTransport model;

    /** Тип двигателя. */
    private final EngineType engine = JET;

    /** Грузоподъемность. */
    private int carryingCapacity;

    public AirTransport(String number, int rentPrice, ModelAirTransport model, int carryingCapacity) {
        super(number, rentPrice);
        this.model = model;
        this.carryingCapacity = carryingCapacity;
    }

    public ModelAirTransport getModel() {
        return model;
    }

    public void setModel(ModelAirTransport model) {
        this.model = model;
    }

    public EngineType getEngine() {
        return engine;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String inspection(String detal) {
        return "Результат осмотра воздушного транспортного средства (" + model + "): ТС действительно повреждено. Место поломки: "
                + detal + ". Требуется ремонт в соответствии с техническими особенностями средства.";
    }

    @Override
    public String repairPart() {
        Random randomno = new Random();
        boolean value = randomno.nextBoolean();
        super.isWork(value);
        return "Результат ремонта: " + value;
    }
}

