package task1;

//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя
//ввод данных.

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        float inputFloatNumber = floatNumberFromConsole();
        System.out.println(inputFloatNumber);
    }

    public static float floatNumberFromConsole() {
        Scanner console = new Scanner(System.in);

        System.out.print("Please, input a float number: ");
        while (!console.hasNextFloat()) {
            console.nextLine();
            System.out.println("Your input is not a float number.. Please, try again..");
            System.out.print("Your input: ");
        }

        System.out.println("Thank you. It could be a float number.");
        return console.nextFloat();
    }
}


