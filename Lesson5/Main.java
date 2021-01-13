package Lesson5;

public class Main {
    public static void main (String [] args){

        //4. Создать массив из 5 сотрудников.
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Василий Рябинов", "Директор", "1970vasr@mail.ru", "89136332941", 230000, 50);
        personArray[1] = new Person("Елена Демидова", "Секретарь", "1999lena@mail.ru", "89136889981", 30000, 21);
        personArray[2] = new Person("Виктор Королёв", "Системный администратор", "1985korol@mail.ru", "89136889999", 60000, 35);
        personArray[3] = new Person("Ирина Демидова", "Финансовый директор", "1965ivd@mail.ru", "89139995566", 130000, 55);
        personArray[4] = new Person("Дядя Ваня", "Водитель", "1960volga@mail.ru", "89089119110", 40000, 60);

        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (int i = 0; i < personArray.length; i++){
            if (personArray[i].age > 40) {
                Person worker = personArray[i];
                worker.PrintPerson();
                System.out.println();
            }
        }
    }
}
