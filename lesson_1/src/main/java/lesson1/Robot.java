package lesson1;

//Создаю класс Робот, задаю поля с именем, ограничениями, создаю геттеры к полям

public class Robot {
    private String runText = " пробежал";
    private String jumpText = " перепрыгнул";
    private String name = "Робот";
    private int lengthMax = 200;
    private int heightMax = 5;

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
