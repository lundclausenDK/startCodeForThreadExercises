package day1.racecondition;

public class Main {
    
    public static void main(String[] args) {
        Even even = new Even();
        
        System.out.println(even.next());
        
        Thread t1 = new Thread(() -> {
            int amount = 0;
            int saveEven = 0;
            while (amount != 5000) {
                
                saveEven = even.next();
                
                if (saveEven % 2 != 0) {
                    System.out.println("T1 error: " + saveEven);
                }
                //System.out.println("T1: " + even.next());
                amount++;
            }
        });
        
        Thread t2 = new Thread(() -> {
            int amount = 0;
            int saveEven = 0;
            while (amount != 5000) {
                
                saveEven = even.next();
                
                if (saveEven % 2 != 0) {
                    System.out.println("T2 error: " + saveEven);
                }
                //System.out.println("T2: " + even.next());
                amount++;
            }
        });
        
        t1.start();
        t2.start();
        
        
        /* ANSWERS
        
            a) Yes, if I set thread 1 and 2 to run even.next() 5000 times each, uneven numbers are retuned and printet
        
            b) I get up to 1500 un-even errors when thread 1 and 2 runs even.next() 500 each at the same time
        
            c) If I put synchronized on the next() method, I cannot reproduce any errors. All numbers are even now.
        
            d) Im thinking that the next() method now waits until it has finished until being run again by other threads
       
        */
        
    }
    
}
