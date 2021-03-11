package Park;

/**
 * Сотрудник.
 * Содержит информацию о сотруднике, который работает в зоопарке.
 *
 * @author Ann Kazakina
 * @since 1.0
 */
public class Employee {

    private String name;
    private int age;
    private int zp;
    private String position;

    public Employee(String name, int age, int zp, String position) {
        this.name = name;
        this.age = age;
        this.zp = zp;
        this.position = position;
    }

    /**
     * Информация о сотруднике.
     *
     * @return информация в виде ткста
     */
    public String information () {
        return "имя: " + name +
                ", возраст: " + age +
                ", должность: " + position +
                ", заработная плата: " + zp + "р.\n";
    }



}
