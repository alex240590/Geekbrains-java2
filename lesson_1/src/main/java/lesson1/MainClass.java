package lesson1;

public class MainClass {
    public static void main(String[] args) {

        //Создаю объекты Человека, Кота, Робота, Беговой дорожки, Стены
        //Помещаю участников в первый массив объектов
        //Помещаю препятвия во второй массив объектов

        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();
        Treadmill treadmill = new Treadmill();
        Wall wall = new Wall();

        Object[] participants = {human, cat, robot};
        Object[] obstacles = {treadmill, wall};


        //Через циклы for к каждому объекту участников поочередно подставляю препятствия
        //Внутри циклов for сначала проверяю принадлежность объекта участника к классу Человек
        //Затем проверяю принадлежность объекта препятсвия к классу Беговая дорожка
        //При обоих значениях true обращаюсь к полям с длиной объектов Человек и Беговая дорожка
        //чтобы выяснить, может или нет он пробежать, если не может - перехожу в else
        //в else поставил break, чтобы дальше участник не шел на проверку прыжка

        //затем в else if то же самое для прыжка

        //затем в else if проверяю те же условия для объектов классов Кота и Робота

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (participants[i] instanceof Human) {
                    if (obstacles[j] instanceof Treadmill) {
                       if (((Human)participants[i]).getLengthMax() > ((Treadmill)obstacles[j]).getLength()) {
                           System.out.println(((Human)participants[i]).getName()+((Human)participants[i]).getRunText());
                       }
                       else {
                           System.out.println(((Human) participants[i]).getName() + " не смог пробежать");
                           break;
                       }
                    } else if (obstacles[j] instanceof Wall){
                        if (((Human)participants[i]).getHeightMax() > ((Wall)obstacles[j]).getHeight()) {
                            System.out.println(((Human)participants[i]).getName()+((Human)participants[i]).getJumpText());
                        }
                        else System.out.println(((Human)participants[i]).getName()+" не смог перепрыгнуть");
                    }
                }

                else if (participants[i] instanceof Cat) {
                    if (obstacles[j] instanceof Treadmill) {
                        if (((Cat)participants[i]).getLengthMax() > ((Treadmill)obstacles[j]).getLength()) {
                            System.out.println(((Cat)participants[i]).getName()+((Cat)participants[i]).getRunText());
                        }
                        else {
                            System.out.println(((Cat) participants[i]).getName() + " не смог пробежать");
                            break;
                        }
                    } else if (obstacles[j] instanceof Wall){
                        if (((Cat)participants[i]).getHeightMax() > ((Wall)obstacles[j]).getHeight()) {
                            System.out.println(((Cat)participants[i]).getName()+((Cat)participants[i]).getJumpText());
                        }
                        else System.out.println(((Cat)participants[i]).getName()+" не смог перепрыгнуть");
                    }
                }

                else if (participants[i] instanceof Robot) {
                    if (obstacles[j] instanceof Treadmill) {
                        if (((Robot)participants[i]).getLengthMax() > ((Treadmill)obstacles[j]).getLength()) {
                            System.out.println(((Robot)participants[i]).getName()+((Robot)participants[i]).getRunText());
                        }
                        else {
                            System.out.println(((Robot) participants[i]).getName() + " не смог пробежать");
                            break;
                        }
                    } else if (obstacles[j] instanceof Wall){
                        if (((Robot)participants[i]).getHeightMax() > ((Wall)obstacles[j]).getHeight()) {
                            System.out.println(((Robot)participants[i]).getName()+((Robot)participants[i]).getJumpText());
                        }
                        else System.out.println(((Robot)participants[i]).getName()+" не смог перепрыгнуть");
                    }
                }
            }
        }
    }
}
