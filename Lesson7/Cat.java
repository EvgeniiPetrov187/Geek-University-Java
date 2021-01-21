package Lesson7;

public class Cat {
    private String name;
    private int wantToEat;
    private int fullness;

    Cat(String name, int wantToEat){
        this.name = name;
        this.wantToEat = wantToEat;
    }

    Cat(){
        this.name = "Васька";
        this.wantToEat = 100;
        this.fullness = 0;
    }

    public void eat(Bowl bowl){
        if (this.fullness == 100) {     // 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
            System.out.println("Кот " + name + " уже сыт");
        } else if (this.fullness < 100 && bowl.getContent() >= wantToEat) {     //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
            System.out.println("Кот " + name + " хочет съесть "+ wantToEat + " грамм еды");
            if (100 - this.fullness < wantToEat){
                wantToEat = 100 -this.fullness;
                System.out.println("Но кот " + name + " может съесть только " + wantToEat + " грамм еды");
            }
            bowl.foodDecrease(wantToEat);
            this.fullness += wantToEat;
            System.out.println("Кот " + name + " съел " + wantToEat + " грамм еды из миски " + bowl.getBowlName());
        } else if (bowl.getContent() < wantToEat) {     //4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
            System.out.println("Кот " + name + " хочет съесть "+ wantToEat + " грамм еды");
            System.out.println("В миске "+ bowl.getBowlName() + " не хватает еды. Нужно ещё " + (wantToEat - bowl.getContent()) + " грамм");
        }
    }

    public void catFullness(){
        System.out.println("Кот "+ name + " сыт на " + this.fullness + "%");
    }

    public void setWantToEat(int wantToEat) {
        this.wantToEat = wantToEat;
    }
    public int getWantToEat() {
        return wantToEat;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFullness(int fullness) {
        this.fullness = fullness;
    }
    public int getFullness() {
        return fullness;
    }
}
