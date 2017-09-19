package day2.webscraper;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        
        long start = System.nanoTime();
        
        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
        tc3.start();
        
        long end = System.nanoTime();

        tc1.join();
        tc2.join();
        tc3.join();

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        

       
        
        System.out.println("Time parallel : " + (end - start));

    }
}


/* ANSWERS: 
    
    a) Because all assignments has to wait until the prior action is done. Here we need more threads.

    b) Just extend the TagCounter class with Thread and swop the main runs with start.

    c) Addition of join fixed the 0'es

    d) Simple, parallels can run side by side. Sequences works as an stafet running

*/
