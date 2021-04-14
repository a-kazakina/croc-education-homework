package ru.croc.homework7.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework7.dbprovider.DataSourceProvider;
import ru.croc.homework7.model.Animal;
import ru.croc.homework7.repository.AnimalRepository;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Проверка CRUD-операций и прикладных методов класса {@link: AnimalService}.
 * Все методы класса AnimalRepository проверяются также здесь.
 */
public class AnimalServiceTest {

    @Test
    @DisplayName("Тест проверки CRUD-операций и прикладных методов класса")
    public void ServiceTest() throws IOException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        AnimalRepository animalRepository = new AnimalRepository(dataSourceProvider.getDataSource());
        AnimalService service = new AnimalService(animalRepository);

        LocalDate date = LocalDate.of(2000, 10, 3);
        Date dateOfBirth = Date.valueOf(date);

        Animal animal1 = new Animal(1, "слон", 4, dateOfBirth, false, 1);
        Animal animal2 = new Animal(2, "жираф", 4, dateOfBirth, false, 2);
        Animal animal3 = new Animal(3, "тигр", 4, dateOfBirth, true, 3);

        // проверка INSERT
        service.addAnimal(animal1);
        service.addAnimal(animal2);
        Assertions.assertTrue(service.findAnimal(1).equals(animal1));

        // проверка UPDATE и метода, который ищет животное в таблице
        // проверяем полную замену строки в таблице
        service.updateAnimal(1, animal3);
        Assertions.assertFalse(service.isAnimal(1));
        Assertions.assertTrue(service.findAnimal(3).equals(animal3));

        date = LocalDate.of(2020, 07, 31);
        dateOfBirth = Date.valueOf(date);

        // проверяем частичные замены строки
        service.updateAnimalId(3, 5);
        service.updateAnimalName(5, "паук");
        service.updateAnimalLimbs(5, 2);
        service.updateAnimalDateOfBirth(5, dateOfBirth);
        service.updateAnimalPredator(5, false);
        service.updateAnimalAviaryNumber(5, 10);
        animal3.setId(5);
        animal3.setName("паук");
        animal3.setLimbs(2);
        animal3.setDateOfBirth(dateOfBirth);
        animal3.setPredator(false);
        animal3.setAviaryNumber(10);
        Assertions.assertTrue(service.findAnimal(5).equals(animal3));

        // проверка DELETE и метода, проверяющего существование животного в таблице
        service.deleteAnimal(2);
        Assertions.assertFalse(service.isAnimal(2));

        // проверка READ
        Animal animal4 = new Animal(4, "лев", 4, dateOfBirth, true, 3);
        service.addAnimal(animal4);
        List<Animal> animals = new ArrayList<>();
        animals.add(animal3);
        animals.add(animal4);
        Assertions.assertEquals(animals, service.getAll());

        // проверка полуения количества записей
        Assertions.assertEquals(2, service.kolAnimal());

        // после завершения теста удаляю таблицу для возможности повторения теста без ошибок
        service.deleteTable();
    }
}
