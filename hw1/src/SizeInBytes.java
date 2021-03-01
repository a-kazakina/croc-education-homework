import java.util.Scanner;

public class SizeInBytes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер в байтах: ");
        float size = sc.nextFloat();
        printBytes(size);

    }
    
    /*
    * Процедура, которая форматирует и выводит на экран заданный размер в байтах в человекочитаемом виде.
    */
    public static void printBytes(float size){

        long b, kb, mb, gb, tb, pb;
        b = 1024; kb = b*1024; mb = kb*1024; gb = mb*1024; tb = gb*1024; pb = tb*1024;

        if (size < 0)
            System.out.println("Неверное значение, размер не может быть отрицательным");

        else if (size > 0 && size < b) {
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " B");
        }

        else if (size >= b && size < kb) {
            size /= b;
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " KB");
        }

        else if (size >= kb && size < mb) {
            size /= kb;
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " MB");
        }

        else if (size >= mb && size < gb) {
            size /= mb;
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " GB");
        }

        else if (size >= gb && size < tb) {
            size /= gb;
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " TB");
        }

        else if (size >= tb && size < pb) {
            size /= tb;
            String normsize = String.format("%.1f", size);
            System.out.println(normsize + " PB");
        }

    }
}
