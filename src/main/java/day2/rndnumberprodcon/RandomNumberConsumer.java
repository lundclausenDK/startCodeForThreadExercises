package day2.rndnumberprodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomNumberConsumer implements Runnable {

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  //Should eventually hold the sum of all random number consumed
  int sumTotal = 0;
  List<Integer> below50 = new ArrayList();
  List<Integer> aboveOr50 = new ArrayList();

  @Override
  public void run() {
    //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume
    for (int i = 0; i < 400; i++) {
        try {
            //Todo: Fetch numbers from numbersProduced and do what you have to do
            int fetchNumber = numbersProduced.take();
            sumTotal += fetchNumber;
            if (fetchNumber < 50) {
                below50.add(fetchNumber);
            } else if (fetchNumber >= 50) {
                aboveOr50.add(fetchNumber);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomNumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }

  
  public int getSumTotal() {
    return sumTotal;
  }

  public List<Integer> getBelow50() {
    return below50;
  }

  public List<Integer> getAboveOr50() {
    return aboveOr50;
  }
  
}
