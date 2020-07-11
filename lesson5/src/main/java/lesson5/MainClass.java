package lesson5;

public class MainClass {

    //Задаю размер основного массива и размер массивов для работы в потоках
    //Создаю для каждого метода два одинаковых массива

    static final int size = 10000000;
    static final int h = size/2;
    public static float[] arrForMethodOne = new float[size];
    public static float[] arrForMethodTwo = new float[size];

    public static void main (String[]args) {

        //Запускаю оба метода

        methodInOneThread();
        methodInTwoThreads();
    }

    //Метод инициализации основных массивов заначениями "1"
    public static void arrInitialization(int arrFirstSize, float[]arrayFirst) {
        for (int i=0; i<arrFirstSize; i++) {
            arrayFirst[i]=1;
        }
    }

    //Метод для выполнения математических операций для основного массива метода1 и вспомогательного массива метода2
    public static void arrCalculation(int arrNewSize, float[]arrayNew){
        for (int i=0; i<arrNewSize; i++) {
            arrayNew[i]=(float)(arrayNew[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
        }
    }

    //Метод для выполнения математических операций вспомогательного массива метода2
    public static void arrCalculationForMethodTwoArr2(int arrNewSizeTwo, float[]arrayNewTwo){
        for (int j=0;j<arrNewSizeTwo; j++) {
            arrayNewTwo[j]=(float)(arrayNewTwo[j]*Math.sin(0.2f+(j+5)/5)*Math.cos(0.2f+(j+5)/5)*Math.cos(0.4f+(j+5)/2));
        }
    }

    //Метод1 после инициализации основного массива
    //выполняет в одном потоке математический расчет и засекает время на его выполнение
    public static void methodInOneThread() {
        arrInitialization(size, arrForMethodOne);
        long timeMethodOneStart = System.currentTimeMillis();
        arrCalculation(size, arrForMethodOne);
        long timeMethodOneFinish = System.currentTimeMillis();
        System.out.println(timeMethodOneFinish-timeMethodOneStart);
    }

    //Метод2 после инициализации основного массива
    //создает 2 вспомогательных массива длиной вдвое меньше основного,
    //затем создаются два потока, в каждый из которых копируется
    //половина основного массива и выполняются мат. операции.
    public static void methodInTwoThreads() {
        arrInitialization(size, arrForMethodTwo);
        long timeMethodTwoStart = System.currentTimeMillis();
        final float[] arr1 = new float[h];
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arrForMethodTwo, 0, arr1, 0, h);
                arrCalculation(h, arr1);
            }
        });
        t1.start();
        final float[] arr2 = new float[h];
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arrForMethodTwo, h, arr2, 0, h);
                arrCalculationForMethodTwoArr2(h, arr2);
            }
        });
        t2.start();

        //Ожидаю завершения работы обоих потоков
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Затем "склеиваю" два вспомогательных массива в один основной
        System.arraycopy(arr1,0,arrForMethodTwo,0,h);
        System.arraycopy(arr2,0,arrForMethodTwo,h,h);
        long timeMethodTwoFinish = System.currentTimeMillis();

        //Засекаю время на выполнение разделения массива, выполнение операций и "склейки"
        System.out.println(timeMethodTwoFinish-timeMethodTwoStart);
    }

}
