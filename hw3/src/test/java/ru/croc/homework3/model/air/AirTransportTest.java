package ru.croc.homework3.model.air;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework3.model.characteristics.ModelAirTransport;

/**
 * Проверка {@link AirTransport}
 */
public class AirTransportTest {

    @Test
    @DisplayName("Тест методов воздушных ТС")
    public void testAirTransport(){
        final Plane plane = new Plane("Ту - 334",
                100_000,
                ModelAirTransport.TRANSPORT,
                47_900,
                30,
                50);
        Assertions.assertEquals("Результат осмотра воздушного транспортного средства (TRANSPORT): " +
                "ТС действительно повреждено. Место поломки: крыло. Требуется ремонт в соответствии " +
                "с техническими особенностями средства.",
                plane.inspection("крыло"));
        plane.isRent(false);
        Assertions.assertEquals("ТС находится в аренде",
                                plane.informationAboutRent());
    }
}
