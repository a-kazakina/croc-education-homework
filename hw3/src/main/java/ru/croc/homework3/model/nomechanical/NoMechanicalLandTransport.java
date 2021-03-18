package ru.croc.homework3.model.nomechanical;

import ru.croc.homework3.model.Transport;
import ru.croc.homework3.model.characteristics.ModelNonMechanicalLandTransport;

import java.util.Random;

/**
 * Немеханический наземный транспорт.
 */
public class NoMechanicalLandTransport extends Transport {

    /** Модель транспорта. */
    private ModelNonMechanicalLandTransport model;

    /** Цвет транспорта. */
    private String color;

    public NoMechanicalLandTransport(String number, int rentPrice, ModelNonMechanicalLandTransport model, String color) {
        super(number, rentPrice);
        this.model = model;
        this.color = color;
    }

    public ModelNonMechanicalLandTransport getModel() {
        return model;
    }

    public void setModel(ModelNonMechanicalLandTransport model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String inspection(String detal) {
        return "Результат осмотра немеханического наземного транспорта (" + model + "): ТС действительно повреждено. Место поломки: " + detal +
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
