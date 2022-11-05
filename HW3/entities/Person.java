package entities;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;
    private Character gender;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public static int countPersonFields() {
        Class classItself = Person.class;
        int counter = 0;
        for (Field field : classItself.getDeclaredFields()) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "<" + lastName + "><" + firstName + "><" + middleName + "><" + birthDate + "><" + phoneNumber + "><" + gender + ">";
//         <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
    }
}
