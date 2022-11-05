import entities.PersonService;
import entities.PersonServiceInt;

import java.io.IOException;
import java.util.Scanner;

public class Main {
//    Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//    Фамилия Имя Отчество датарождения номертелефона пол
//    Форматы данных:
//    фамилия, имя, отчество - строки
//
//    дата_рождения - строка формата dd.mm.yyyy
//
//    номер_телефона - целое беззнаковое число без форматирования
//
//    пол - символ латиницей f или m.
//
//    Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
//    ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
//    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных
//    не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
//    Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку
//    должны записаться полученные данные, вида
//
//            <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//(*) Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//    Не забудьте закрыть соединение с файлом.
//
//            (*) При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

    public static void main(String[] args) throws IllegalAccessException, IOException {
//        Scanner console = new Scanner(System.in);
        String dataFormatExceprionString = "###, hhhhh, jjjjj, 9999999, &&&, )))))\n";
        String dateFormatExceprionString = "01-01-2000 m Ivanov Ivan 89123455 Ivanovich\n";
        String incorrectNumberOfWordsString = "01-01-2000 m Chernov Boris m 89123455 Vladimirovich\n";
        String nullDataInClassException = "01-01-2000 m Chernov Boris m Vladimirovich\n";

        String inputString = "Ivanov Pert Ivanovich 29.03.1990 1234567 m\n" +
                "  20.01.1992 Chernova Irina  Pavlovna 76543213 f   \n" +
                "m 03.07.1987 6543217   Lisin Ivan Vladimirovich\n" +
                "Kolobkov 09.08.1979 Igor m 7890643 Sergeevich\n" +
                "10.10.1960 m Ivanov Ivan 89123455 Ivanovich\n";

        PersonServiceInt personService = new PersonService();
        Scanner console = new Scanner(inputString);
        while (console.hasNext()) {
            String input = console.nextLine();
            personService.checkAndParseString(input);
        }
    }
}
