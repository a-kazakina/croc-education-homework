package Park;

import java.util.Arrays;

/**
 * Зоопарк.
 * Содержит информацию о зопарке, животных и сотрудниках, которые находятся там.
 *
 * @author Ann Kazakina
 * @since 1.0
 */
public class Zoo {

    private Animal[] animals = new Animal[] {};

    /**
     * Добавить нового животного.
     *
     * @param animal животное
     */
    public void add(Animal animal) {
        animals = Arrays.copyOf(animals, animals.length + 1);
        animals[animals.length - 1] = animal;
    }

    /**
     * Удалить животное.
     *
     * @param animal животное
     */
    public void remove (Animal animal) {
        final Animal[] newAnimals = new Animal[animals.length - 1];
        int index = 0;
        for (Animal currentAnimal : animals) {
            if (currentAnimal != animal) {
                newAnimals[index++] = currentAnimal;
            }
        }
        animals = newAnimals;
    }

    /**
     * Возвращает всех животных.
     *
     * @return список животных
     */
    public Animal[] all() {
        return Arrays.copyOf(animals, animals.length);
    }

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в зоопарк!\n");

        Zoo animals = new Zoo();

        Aviary aviary1 = new Aviary(50, "клетка", 1);
        Employee responsible1 = new Employee("Анна", 20, 20_000, "смотритель");
        Animal animal1 = new Animal("Гоша", "тигр", aviary1, responsible1);

        Aviary aviary2 = new Aviary(100, "бассейн", 2);
        Employee responsible2 = new Employee("Анастасия", 20, 20_000, "смотритель");
        Animal animal2 = new Animal("Кира", "дельфин", aviary2, responsible2);

        animals.add(animal1);
        animals.add(animal2);

        aviary1.addCleaning("21.01.2021");
        aviary2.addCleaning("22.01.2021");

        animal1.addFeeding("Покормлен в 12:00");
        animal1.addFeeding("Покормлен в 14:00");
        animal2.addFeeding("Покормлен в 13:00");

        animal2.addDisease("Есть кожная болезнь");

        // были Гоша и Кира
        System.out.println("Население зоопарка:");
        for (Animal animal : animals.all()) {
            System.out.println("\tИнформация о животном: " + animal.information()+ "\n");
        }

        animals.remove(animal2);

        // остался только Гоша
        System.out.println("Население зоопарка:");
        for (Animal animal : animals.all()) {
            System.out.println("\tИнформация о животном: " + animal.information());
        }
    }

}
