package lesson1;

//Создаю класс Человек, задаю поля с именем, ограничениями, создаю геттеры к полям

public class Human {
    private String runText = " пробежал";
    private String jumpText = " перепрыгнул";
    private String name = "Человек";
    private int lengthMax = 100;
    private int heightMax = 3;

    public String getName() {
        return name;
    }

    public String getRunText() {
        return runText;
    }

    public String getJumpText() {
        return jumpText;
    }

    public int getLengthMax() {
        return lengthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }




}
