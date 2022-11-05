package task4;

//        Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.


import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);

        String str = console.nextLine();
        if ("".equals(str)) {
            throw new Exception("Empty string has been input.");
        } else {
            System.out.println("Your input was - " + str);
        }
    }
}
