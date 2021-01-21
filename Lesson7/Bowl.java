package Lesson7;

public class Bowl {
    private  String bowlName;
    private int content;
    Bowl(String bowlName, int content){
        this.content = content;
        this.bowlName = bowlName;
    }

    public void info(){
        if (content == 0){
            System.out.println("Миска " + bowlName + " пуста");
        } else {
        System.out.println("В миске " + bowlName + " осталось " + content + " грамм еды");
        }
    }

    public void foodDecrease(int portion){
        if (content >= portion){
        content -= portion;
        }
    }

    // 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public void fillBowl(int food){
        content +=food;
        System.out.println("Добавлено в миску " + bowlName + " " + food + " грамм еды");
    }

    public void setContent(int content) {
        this.content = content;
    }
    public int getContent() {
        return content;
    }
    public void setBowlName(String bowlName){
        this.bowlName = bowlName;
    }
    public String getBowlName(){
        return bowlName;
    }
}
