package lesson1;

//Создаю класс Кот, задаю поля с именем, ограничениями, создаю геттеры к полям

public class Cat {
    private String runText = " пробежал";
    private String jumpText = " перепрыгнул";
    private String name = "Кот";
    private int lengthMax = 40;
    private int heightMax = 2;

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
