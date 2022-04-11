package jp.co.mdmy;

public class ThreadTest {

    public static void main(String[] args) {


        Runnable r1 = new INNER_T1();
        Runnable r2 = new INNER_T2();


        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}
