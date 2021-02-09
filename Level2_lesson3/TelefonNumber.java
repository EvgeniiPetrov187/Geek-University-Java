package Level2_lesson3;

// 2. Написать простой класс Телефонный Справочник, который хранит в себе список
// фамилий и телефонных номеров.
public class TelefonNumber {
    private String name;
    private String number;

    public TelefonNumber(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}