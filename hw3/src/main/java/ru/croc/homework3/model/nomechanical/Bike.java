package ru.croc.homework3.model.nomechanical;

import ru.croc.homework3.model.characteristics.ModelNonMechanicalLandTransport;

/**
 * Велосипед.
 */
public class Bike extends NoMechanicalLandTransport {

    /** Материал, из которого изготовлена рама. */
    private String frame;

    /** Количество скоростей. */
    private int kolSpeeds;

    /**
     * Конструктор объекта Велосипед.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param model модель
     * @param color цвет
     * @param frame рама
     * @param kolSpeeds количсетво скоростей
     */
    public Bike(String number, int rentPrice, ModelNonMechanicalLandTransport model, String color,
                String frame, int kolSpeeds) {
        super(number, rentPrice, model, color);
        this.frame = frame;
        this.kolSpeeds = kolSpeeds;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public int getKolSpeeds() {
        return kolSpeeds;
    }

    public void setKolSpeeds(int kolSpeeds) {
        this.kolSpeeds = kolSpeeds;
    }
}
