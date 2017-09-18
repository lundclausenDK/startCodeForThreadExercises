package day1.paralells;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parallels {
    
    private static Boolean nameState = true;

    public static void main(String[] args) throws InterruptedException {

        

        Thread t1 = new Thread(() -> {
            int bio = 0;
            Long sum = 0L;
            while (bio != 1000000000) {
                bio++;
                sum += bio;
                //System.out.println("T1:bio " + bio);
                //System.out.println("T1:sum " + sum);
                System.out.println("T1: " + bio + (sum + 1));
            }
        });
        
        Thread t2 = new Thread(() -> {
            int numbers = 0;
            while (numbers != 5) {
                numbers++;
                System.out.println("T2: " + numbers);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Parallels.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread t3 = new Thread(() -> {
            int startTen = 10;

            while(nameState) {
                System.out.println("T3: " + startTen);
                startTen++;
            }
        });

        t1.start();
        t2.start();
        t3.start();
        
        Thread.sleep(10000);
        nameState = false;
        System.out.println("TX for waiting");
        
        
        /* ANSWERS
        
            a) At first glance I dont see a need for sync in this exercise
        
            b) Sorry, dont see the problem. The program runs all threads and sleeps them as planned.
        
            c) Please see answer b. Please give me feedback on where the problem is :) just started learning about threads.
        
        */

    }

}
