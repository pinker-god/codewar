package kata;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        String morse[] = morseCode.split(" ");
        StringBuilder builder = new StringBuilder();
        System.out.println(Arrays.toString(morse));
        for (int i = 0; i < morse.length; i++) {
            if (morse[i].equals("")) {
                builder.append(" ");
                i++;
            } else
                builder.append(MorseCode.get(morse[i]));
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        /*String morseCode = ".... . -.--   .--- ..- -.. .";
        String morse[] = morseCode.split(" ");
        System.out.println(Arrays.toString(morse));
        for (int i = 0; i < morse.length; i++) {
            if (morse[i].equals(""))
                System.out.println("我里面没有空格");
            if (morse[i].equals(" "))
                System.out.println("我里面有空格");
        }*/
//        testScheduleAtFixedRate();
        testscheduleWithFixedDelay();
    }

    private static void testscheduleWithFixedDelay() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t" + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (pool.isTerminated()) {
            pool.shutdown();
        }
    }

    private static void testScheduleAtFixedRate() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t" + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (pool.isTerminated()) {
            pool.shutdown();
        }
    }
}