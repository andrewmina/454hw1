import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        philosopher[] philosophers = new philosopher[5];

        ArrayList<chopStick> sticks = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            sticks.add(new chopStick());
        }


        ArrayList<Semaphore> semaphores= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            semaphores.add(new Semaphore(1));
        }

        for (int i = 0; i < philosophers.length; i++) {



            philosophers[i] = new philosopher(i, sticks, semaphores);

        }
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i].start();
        }

        System.out.println(sticks);



    }

}