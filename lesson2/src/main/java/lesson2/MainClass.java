package lesson2;



public class MainClass {

//Создаю поля с размерами матрицы x, y, создаю пустой массив размером 4х4,
//Создаю строку и передаю ее для записи в массив 4x4 String[][] методу method1.
//Вызываю метод method2 для преобразования элементов массива в числа типа int и
//выполнения математических операций

    public static int x = 4;
    public static int y = 4;
    public static String [][] array4x4 = new String[x][y];
    public static String line = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    public static void main (String[] args) {

        method1(line);
        method2();

    }

    //в method1 сначала разделяю строку на 4 новые строки по символу перехода к новой строке;
    //затем идет исключение для сравнения количества получившихся строк с длиной массива4х4;
    //в цикле разделяю каждую из 4 строк еще на 4 строки;
    //пишу исключение для сравнения количества получившихся строк с шириной массива4х4;
    //записываю в массив array4x4 значения разделенных 16-ти строк

    public static void method1(String a) {
        String [] subString1 = a.split("\n");
        if (x != subString1.length) {
            throw new RuntimeException();
        }
        for (int i=0; i<subString1.length; i++) {
            String[] subString2 = subString1[i].split(" ");
            if (y != subString2.length) {
                throw new RuntimeException();
            }
            for (int j = 0; j < subString2.length; j++) {
                array4x4[i][j] = subString2[j];

//                System.out.print(array4x4 [i][j]);
            }
        }

    }

    //в method2 создаю пустой массив чисел размера 4х4, а также поле суммы;
    //в цикле привожу строковые значения массива array4x4 к числовым типа int массива array2;
    //пишу исключение для проверки соответсвия числового типа значения массива
    //выполняю математические операции и вывожу результат в консоль

    public static void method2() {
        int[][] array2 = new int[x][y];
        int Summ = 0;
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                try {
                    array2[i][j] = Integer.parseInt(array4x4[i][j]);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
//                System.out.print(array2[i][j]);
                Summ = Summ+array2[i][j];
            }
        }
        Summ=Summ/2;
        System.out.println(Summ);
    }

}
