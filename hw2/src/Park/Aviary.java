package Park;

import java.util.Arrays;

/**
 * Вольер.
 * Содержит информацию о помещении, в котором пребывает животное.
 *
 * @author Ann Kazakina
 * @since 1.0
 */
public class Aviary {

    private int area;
    private String kind;
    private int number;
    private String[] clean = new String[] {};

    public Aviary (int area, String kind, int number) {
        this.area = area;
        this.kind = kind;
        this.number = number;
    }

    /**
     * Информация о вольере.
     *
     * @return информация в виде текста
     */
    public String information () {
        return kind + " под номером " + number + " площадью " + area + " км.м.";
    }

    /**
     * Добавить запись об уборке вольера.
     *
     * @param cleaning запись об уборке.
     */
    public void addCleaning(String cleaning) {
        clean = Arrays.copyOf(clean, clean.length + 1);
        clean[clean.length - 1] = cleaning;
    }

    /**
     * Информация об уборке вольера.
     *
     * @return информация в виде текста
     */
    public String information_about_cleaning() {
        String information = "";
        for (String elem : clean) {
            information += elem + "\n";
        }
        return information;
    }

}
