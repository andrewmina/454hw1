import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class philosopher extends Thread {

    private int position;
    private ArrayList<chopStick> sticks;

    private ArrayList<Semaphore> chopstickSemaphores;



    public philosopher(int position, ArrayList<chopStick> sticks, ArrayList<Semaphore> chopstickSemaphores) {
        this.position = position;
        this.sticks = sticks;
        this.chopstickSemaphores =  chopstickSemaphores;
    }

    @Override
    public void run() {
        while (true) {

            think();
            startChop();

            eat();


            stopChop();
        }
    }

    public void eat() {

        int stick1 = (position + sticks.size() - 1) % sticks.size();
        int stick2 = (position + 1) % sticks.size();

        if (!sticks.get(stick1).isFree()) {
            System.out.println("Stick 1 not available!!");
        }
        if (!sticks.get(stick2).isFree()) {
            System.out.println("Stick 2 not available!!");
        }else {
            System.out.println("Philosopher " + this.getName() + " is eating");
            sticks.get(stick1).use();
            sticks.get(stick2).use();
        }
    }
    public void think() {
        System.out.println("Philosopher " + this.getName() + " is thinking");
        try {
            Thread.sleep(1000); // Philosopher will think for 1000 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startChop() {

        int stick1 = (position + 4) % 5;
        int stick2 = (position + 1) % 5;
            try {
                chopstickSemaphores.get(stick1).acquire();
                chopstickSemaphores.get(stick2).acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Philosopher " + this.getName() + " has acquired chopsticks " + stick1 + " and " + stick2);

    }
    private void stopChop(){

        int stick1 = (position + 4) % 5;
        int stick2 = (position + 1) % 5;
        chopstickSemaphores.get(stick1).release();
        chopstickSemaphores.get(stick2).release();
        System.out.println("Philosopher " + this.getName() + " has released chopsticks " + stick1 + " and " + stick2);

    }
}
