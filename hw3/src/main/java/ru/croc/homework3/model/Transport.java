package ru.croc.homework3.model;

/**
 * Транспорт.
 */
public abstract class Transport {

    /**  Номер транспорта. */
    private String number;

    /** Стоимость аренды. */
    private int rentPrice;

    /** Статус аренды. */
    private boolean rentStatus = true;

    /** Статус исправности. */
    private boolean workStatus = true;

    public Transport(String number, int rentPrice) {
        this.number = number;
        this.rentPrice = rentPrice;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    /**
     * Процедура позволяет изменять статус аренды ТС.
     *
     * @param rentStatus статус
     */
    public void isRent(boolean rentStatus){
        this.rentStatus =  rentStatus;
    }

    /**
     * Процедура позволяет изменять статус исправности ТС.
     *
     * @param workStatus статус
     */
    public void isWork(boolean workStatus){
        this.workStatus =  workStatus;
    }

    /**
     * Информация об аренде ТС.
     *
     * @return информация об аренде в виде текста
     */
    public String informationAboutRent(){
        if (rentStatus == false) return "ТС находится в аренде";
        else return "ТС свободно";
    }

    /**
     * Информация об исправности ТС.
     *
     * @return информация об исправности в виде текста
     */
    public String informationAboutWork(){
        if (workStatus == true) return "ТС исправно";
        else return "ТС неисправно";
    }

    /**
     * Осмотр транспортного средства.
     *
     * @param detal сломанная деталь
     * @return результат осмотра в виде текстовой информации
     */
    public abstract String inspection(String detal);

    /**
     * Ремонт сломанной детали.
     *
     * @return true - ремонт прошел успешно, ТС исправно; false - иначе
     */
    public abstract String repairPart();
}
