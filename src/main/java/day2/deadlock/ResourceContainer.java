package day2.deadlock;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceContainer {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    //List<String> words = new ArrayList();
    //List<Integer> numbers = new ArrayList();
    ConcurrentLinkedQueue words = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue numbers = new ConcurrentLinkedQueue();

    public ConcurrentLinkedQueue getResourceWords() throws InterruptedException {
        lock1.lockInterruptibly();
        return words;
    }

    public void releaseResourceWords() {
        lock1.unlock();
    }

    public ConcurrentLinkedQueue getResourceNumbers() throws InterruptedException {
        lock2.lockInterruptibly();
        return numbers;
    }

    public void releaseResourceNumbers() {
        lock2.unlock();
    }

}
