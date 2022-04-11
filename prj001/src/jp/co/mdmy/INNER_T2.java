package jp.co.mdmy;

import static java.lang.Thread.sleep;

public class INNER_T2 implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {

            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread-2 : " + String.valueOf(i));
        }
    }
}
