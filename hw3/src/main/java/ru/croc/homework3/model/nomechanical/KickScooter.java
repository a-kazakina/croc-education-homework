package ru.croc.homework3.model.nomechanical;

import ru.croc.homework3.model.characteristics.ModelNonMechanicalLandTransport;

/**
 * Самокат.
 */
public class KickScooter extends NoMechanicalLandTransport {

    /** Складной или нет. */
    private boolean collapsable;

    /** Подножка есть или нет. */
    private boolean tripUp;

    /**
     * Конструктор объекта Самокат.
     *
     * @param number номер
     * @param rentPrice стоимость аренды
     * @param model модель
     * @param color цвет
     * @param collapsable складной
     * @param tripUp подножка
     */
    public KickScooter(String number, int rentPrice, ModelNonMechanicalLandTransport model, String color,
                       boolean collapsable, boolean tripUp) {
        super(number, rentPrice, model, color);
        this.collapsable = collapsable;
        this.tripUp = tripUp;
    }

    public boolean isCollapsable() {
        return collapsable;
    }

    public void setCollapsable(boolean collapsable) {
        this.collapsable = collapsable;
    }

    public boolean isTripUp() {
        return tripUp;
    }

    public void setTripUp(boolean tripUp) {
        this.tripUp = tripUp;
    }
}
