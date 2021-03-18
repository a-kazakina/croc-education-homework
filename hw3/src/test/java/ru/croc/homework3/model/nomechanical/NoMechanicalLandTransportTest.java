package ru.croc.homework3.model.nomechanical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework3.model.characteristics.ModelNonMechanicalLandTransport;

/**
 * Проверка {@link NoMechanicalLandTransportTest}
 */
public class NoMechanicalLandTransportTest {

    @Test
    @DisplayName("Тест методов немеханического ТС")
    public void testNoMechanicalTransport() {
        final KickScooter kickScooter = new KickScooter("34567",
                600,
                ModelNonMechanicalLandTransport.CHILD,
                "blue",
                true,
                true);
        Assertions.assertEquals("Результат осмотра немеханического наземного транспорта (CHILD): " +
                "ТС действительно повреждено. Место поломки: колесо. Требуется ремонт в соответствии " +
                "с техническими особенностями средства.",
                kickScooter.inspection("колесо"));
        Assertions.assertEquals("ТС исправно",
                                kickScooter.informationAboutWork());
    }
}
