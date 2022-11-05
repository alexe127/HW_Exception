package entities;

import exceptions.DataFormatException;
import exceptions.DateFormatException;
import exceptions.IncorrectNumberOfWords;
import exceptions.NullDataInClassException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonService implements PersonServiceInt {
    private String regexPhone = "[0-9]+";
    private String regexGender = "[f, m]{1}";
    private String regexDate = "[0-9]{2}.[0-9]{2}.[0-9]{4}";
    private String regexName = "[а-яёА-ЯЁa-zA-Z]+";
    private final int COUNT_PERSON_FIELDS;

    public PersonService() {
        this.COUNT_PERSON_FIELDS = Person.countPersonFields();
    }

    @Override
    public void checkAndParseString(String input) throws IllegalAccessException, IOException {
        String localString = input.trim().replaceAll(" +", " ");
        Person newPerson = new Person();
        boolean isLastName = true, isName = true, isMiddleName = true;

//        System.out.println(localString);
        if (!isNumberOfWordsCorrect(localString)) {
            throw new IncorrectNumberOfWords(localString);
        }

        String[] inputWordsArray = localString.split(" ");
        for (String word : inputWordsArray) {
//            System.out.println(word);
            if (isPhoneFormat(word)) {
                newPerson.setPhoneNumber(word);
//                System.out.println("telephone " + word);
            } else if (isGenderFormat(word)) {
                newPerson.setGender(word.charAt(0));
//                System.out.println("gender " + word);
            } else if (isPossibleDateFormat(word)) {
                try {
                    LocalDate.parse(word, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    newPerson.setBirthDate(word);
                } catch (RuntimeException e) {
                    throw new DateFormatException(localString);
                }
//                System.out.println("date " + newPerson.getBirthDate());
            } else if (isAnyNamePartFormat(word)) {
                if (isLastName) {
                    newPerson.setLastName(word);
//                    System.out.println("lastname " + word);
                    isLastName = false;
                } else if (isName) {
                    newPerson.setFirstName(word);
//                    System.out.println("name " + word);
                    isName = false;
                } else if (isMiddleName) {
                    newPerson.setMiddleName(word);
//                    System.out.println("middlename " + word);
                    isMiddleName = false;
                }
            } else {
                throw new DataFormatException(localString);
            }
        }
        if (!areAllFieldsFilled(newPerson)) {
            throw new NullDataInClassException(localString);
        }
//        System.out.println(newPerson);
        writeDataToFile(newPerson);
    }

    private void writeDataToFile(Person person) throws IOException {
        String path = "src\\allfiles\\" + person.getLastName();
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(person.toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
    }

    private boolean isNumberOfWordsCorrect(String str) {
        return str.split(" ").length == COUNT_PERSON_FIELDS;
    }

    private boolean isPhoneFormat(String phoneString) {
        return phoneString.matches(regexPhone);
    }

    private boolean isGenderFormat(String genderString) {
        return genderString.matches(regexGender);
    }

    private boolean isPossibleDateFormat(String dateString) {
        return dateString.matches(regexDate);
    }

    private boolean isAnyNamePartFormat(String nameString) {
        return nameString.matches(regexName);
    }

    private boolean areAllFieldsFilled(Person person) throws IllegalAccessException {
        for (Field field : Person.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(person) == null) {
                return false;
            }
        }
        return true;
    }


}
