package ru.croc.homework3.model.mechanical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework3.model.characteristics.EngineType;

/**
 * Проверка {@link MechanicalLandTransport}
 */
public class MechanicalLandTransportTest {

    @Test
    @DisplayName("Тест методов механического ТС")
    public void testMechanicalTransport() {
        final Car car = new Car("A350BC",
                3_000,
                "KIA",
                150,
                EngineType.INTERNAL_COMBUSTION,
                3,
                4);
        Assertions.assertEquals("Результат осмотра механического наземного транспорта (KIA): " +
                "ТС действительно повреждено. Место поломки: двигатель. Требуется ремонт в соответствии " +
                "с техническими особенностями средства.",
                car.inspection("двигатель"));
        car.isWork(false);
        Assertions.assertEquals("ТС неисправно",
                                car.informationAboutWork());
        car.isRent(false);
        Assertions.assertEquals("ТС находится в аренде",
                                car.informationAboutRent());
    }

}
