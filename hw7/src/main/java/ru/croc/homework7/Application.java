package ru.croc.homework7;

import ru.croc.homework7.dbprovider.DataSourceProvider;
import ru.croc.homework7.model.Animal;
import ru.croc.homework7.repository.AnimalRepository;
import ru.croc.homework7.service.AnimalService;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;

public class Application {

    public static void main(String[] args) throws IOException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        AnimalRepository animalRepository = new AnimalRepository(dataSourceProvider.getDataSource());
        AnimalService service = new AnimalService(animalRepository);

        LocalDate date = LocalDate.of(2000, 10, 3);
        Date dateOfBirth = Date.valueOf(date);

        System.out.println("Занесли в таблицу слона и жирафа: ");
        service.addAnimal(new Animal(1, "слон", 4, dateOfBirth, false, 1));
        service.addAnimal(new Animal(2, "жираф", 4, dateOfBirth, false, 2));
        Animal animal3 = new Animal(3, "тигр", 4, dateOfBirth, true, 3);
        service.getAll().forEach(System.out::println);

        System.out.println("Поменяли слона на тигра и удалили жирафа: ");
        service.updateAnimal(1, animal3);
        service.deleteAnimal(2);
        service.getAll().forEach(System.out::println);

        System.out.println(service.kolAnimal() + " записей о животных в таблице");

        animalRepository.deleteTable();

    }
}
