package day2.deadlock;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResourceUser1 extends Thread {

    ResourceContainer resource;

    ResourceUser1(ResourceContainer r) {
        resource = r;
    }
    boolean doRun = true;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {

                System.out.println(Thread.currentThread().getName() + " Get resource WORDS");
                ConcurrentLinkedQueue words = resource.getResourceWords();
                words.add("Peter");
                words.add("Kurt");
                words.add("Hanne");
                Thread.sleep(1);//Simulate that using the resource takes som time 
                System.out.println(Thread.currentThread().getName() + " Get resource NUMBERS");
                ConcurrentLinkedQueue numbers = resource.getResourceNumbers();
                numbers.add(1);
                numbers.add(2);
                numbers.add(3);

                System.out.println(Thread.currentThread().getName() + " Done with resources");

            } catch (InterruptedException ex) {
                Logger.getLogger(ResourceUser1.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                resource.releaseResourceNumbers();
                resource.releaseResourceWords();

            }
        }
    }
}
