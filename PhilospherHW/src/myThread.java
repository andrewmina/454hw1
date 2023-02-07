import java.util.ArrayList;

class myThread extends Thread {
    @Override
    public void run() {
        // Code that you want to run in the thread
    }

    public void eat(int position, ArrayList<Boolean> sticks) {
        // getting which chopsticks the philosopher would use
        int stick1 = position-1 % 5;
        int stick2 = position+1 % 5;

        if(!sticks.get(stick1) || !sticks.get(stick2)){
            System.out.println("One or more sticks not available!!");
        }else {
            sticks.set(stick1, true);
            sticks.set(stick2, true);
        }
    }
}
