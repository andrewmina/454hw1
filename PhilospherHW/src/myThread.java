import java.util.ArrayList;

class philosopher extends Thread {

    private int position;
    private ArrayList<chopStick> sticks;

    public philosopher(int position, ArrayList<chopStick> sticks) {
        this.position = position;
        this.sticks = sticks;
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
        int stick1 = position - 1 % 5;
        int stick2 = position + 1 % 5;
        if (!sticks.get(stick1).isFree()) {
            System.out.println("Stick 1 not available!!");
        }
        if (!sticks.get(stick2).isFree()) {
            System.out.println("Stick 2 not available!!");
        }else {
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

    public void startChop() {
        // getting which chopsticks the philosopher would use
        int stick1 = position - 1 % 5;  // The left chop stick they would use
        int stick2 = position + 1 % 5;  // The right chop stick they would

        while (!sticks.get(stick1).isFree() || !sticks.get(stick2).isFree()) {
//            if (!sticks.get(stick1).isFree()) {
//                System.out.println("Stick 1 not available!!");
//            }
//            if (!sticks.get(stick2).isFree()) {
//                System.out.println("Stick 2 not available!!");
//            }
//        } else {
//            sticks.get(stick1).use();
//            sticks.get(stick2).use();
//        }
//        }

            try {
                wait();  // waiting for the chopstick to be free
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        sticks.get(stick1).use();
        sticks.get(stick2).use();



    }
    private synchronized void stopChop(){
        int stick1 = (position - 1 + 5) % 5;
        int stick2 = (position + 1) % 5;

        sticks.get(stick1).stopUse();
        sticks.get(stick2).stopUse();

        notifyAll();
    }
}
