package jp.co.mdmy;

import static java.lang.Thread.sleep;

public class INNER_T1 implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {

            try {

                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread-1 : " + String.valueOf(i));

            if (i == 10) {
                return;
            }
        }

    }
}
