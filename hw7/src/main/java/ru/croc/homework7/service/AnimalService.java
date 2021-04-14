package ru.croc.homework7.service;

import ru.croc.homework7.model.Animal;
import ru.croc.homework7.repository.AnimalRepository;

import java.sql.Date;
import java.util.List;

/**
 * Прикладной сервис по работе с БД.
 */
public class AnimalService {

    /** Репозиторий для доступа к таблице с данными. */
    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод поиска всех животных в БД.
     *
     * @return список всех животных
     */
    public List<Animal> getAll() {
        return repository.findAll();
    }

    /**
     * Метод добавления нового животного в БД.
     *
     * @param animal животное
     */
    public void addAnimal(Animal animal) {
        repository.addAnimal(animal);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется полностью вся строка с данными.
     *
     * @param id код животного
     * @param animal новая информация о животном
     */
    public void updateAnimal(Integer id, Animal animal) {
        repository.updateAnimal(id, animal);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется код животного.
     *
     * @param beforeId старый код животного
     * @param afterId новый код животного
     */
    public void updateAnimalId(Integer beforeId, Integer afterId) {
        repository.updateAnimalId(beforeId, afterId);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется имя животного.
     *
     * @param id код животного
     * @param newName новое имя животного
     */
    public void updateAnimalName(Integer id, String newName) {
        repository.updateAnimalName(id, newName);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется количество конечностей животного.
     *
     * @param id код животного
     * @param newLimbs новок количество конечностей
     */
    public void updateAnimalLimbs(Integer id, Integer newLimbs) {
        repository.updateAnimalLimbs(id, newLimbs);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется дата рождения животного.
     *
     * @param id код животного
     * @param newDate новая дата рождения
     */
    public void updateAnimalDateOfBirth(Integer id, Date newDate) {
        repository.updateAnimalDateOfBirth(id, newDate);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется о том, является ли животное хищником.
     *
     * @param id код животного
     * @param newPredator хищник/нет
     */
    public void updateAnimalPredator(Integer id, Boolean newPredator) {
        repository.updateAnimalPredator(id, newPredator);
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется номер вольера животного.
     *
     * @param id код животного
     * @param newAviaryNumber новый номер вольера
     */
    public void updateAnimalAviaryNumber(Integer id, Integer newAviaryNumber) {
        repository.updateAnimalAviaryNumber(id, newAviaryNumber);
    }

    /**
     * Метод удаления животного из таблицы БД.
     *
     * @param id код животного
     */
    public void deleteAnimal(Integer id) {
        repository.deleteAnimal(id);
    }

    /**
     * Метод удаления таблицы.
     */
    public void deleteTable() {
        repository.deleteTable();
    }

    /**
     * Метод поиска животногоо по коду в БД.
     * В случае отсутствия выводится "пустое" животное.
     *
     * @param id код животного
     * @return животное
     */
    public Animal findAnimal(Integer id) {
        List<Animal> allAnimal = getAll();
        for (Animal animal : allAnimal) {
            if (animal.getId() == id) {
                 return animal;
            }
        }
        return new Animal();
    }

    /**
     * Метод поиска животногоо по коду в БД.
     * В случае отсутствия выводится "пустое" животное.
     *
     * @param id
     * @return true - есть, false - нет
     */
    public boolean isAnimal(Integer id) {
        List<Animal> allAnimal = getAll();
        for (Animal animal : allAnimal) {
            if (animal.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод вычисления количества записей о животных в БД.
     *
     * @return количество записей.
     */
    public int kolAnimal() {
        return getAll().size();
    }
}
