package Park;

import java.util.Arrays;

/**
 * Животное.
 * Содержит информацию о животном.
 *
 * @author Ann Kazakina
 * @since 1.0
 */
public class Animal {

    private String name;
    private String species;
    private Aviary aviary;
    private Employee responsible;
    private String[] feed = new String[] {};
    private String[] diseases = new String[] {};

    public Animal(String name, String species, Aviary aviary, Employee responsible) {
        this.name = name;
        this.species = species;
        this.aviary = aviary;
        this.responsible = responsible;
    }

    /**
     * Процедура, позволяющая изменить имя животного.
     *
     * @param name имя животного
     */
    public void setName(String name) {
        this.name = "Имя: " + name;
    }

    /**
     * Добавить запись о кормлении животного.
     *
     * @param feeding запись об уборке.
     */
    public void addFeeding(String feeding) {
        feed = Arrays.copyOf(feed, feed.length + 1);
        feed[feed.length - 1] = feeding;
    }

    /**
     * Добавить запись о болезни какого-либо животного.
     *
     * @param disease запись о болезни
     */
    public void addDisease(String disease) {
        diseases = Arrays.copyOf(diseases, diseases.length + 1);
        diseases[diseases.length - 1] = disease;
    }

    /**
     * Информация о кормлении животного.
     *
     * @return информация в виде текста
     */
    private String information_about_feeding() {
        String information = "";
        for (String elem : feed) {
            information += elem + "\n";
        }
        return information;
    }

    /**
     * Информация о болезнях животного.
     *
     * @return информация в виде текста
     */
    private String information_about_diseases() {
        String information = "";
        for (String elem : diseases) {
            information += elem + "\n";
        }
        return information;
    }

    /**
     * Информация о животном.
     *
     * @return информация в виде текста
     */
    public String information() {
        return species + " " + name +
                "\nМесто жительства: " + aviary.information() +
                "\nИнформация об уборке: " + aviary.information_about_cleaning() +
                "Ответственный: " + responsible.information() +
                "Информация о кормлении: " + information_about_feeding() +
                "Информация о болезнях: " + information_about_diseases();
    }

}
