import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        myThread philosopher = new myThread();
//        philosopher.start();
        philosopher[] philosophers = new philosopher[5];


        // creating the 5 philosophers as 5 different threads



        ArrayList<chopStick> sticks = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            sticks.add(new chopStick());
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new philosopher(i, sticks);

        }
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i].start();
        }

        System.out.println(sticks);
//        for(int i = 0; i < list.size(); i++){
//            print(list.get(i));
//        }


    }

}