package Lesson5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Person {
    public final String name;
    public final String place;
    public final String eMail;
    public final String phoneNumber;
    public final double money;
    public final int age;

    public Person(String name, String place, String eMail, String phoneNumber, double money, int age){
        this.name = name;
        this.place = place;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.age = age;
    }
    //2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Person() {
        this.name = "Максим Иванов";
        this.place = "Программист";
        this.eMail = "30max@mail.ru";
        this.phoneNumber = "89997777777";
        this.money = 50000;
        this.age = 30;
    }

    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void PrintPerson() {
        System.out.println("Имя: " + this.name);
        System.out.println("Возраст: " + this.age);
        System.out.println("Должность: " + this.place);
        System.out.println("Электронная почта: " + this.eMail);
        System.out.println("Номер телефона: " + this.phoneNumber);
        System.out.println("Зарплата: " + this.money);
    }


}
