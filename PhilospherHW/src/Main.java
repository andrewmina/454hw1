import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        myThread philosopher = new myThread();
//        philosopher.start();
        myThread[] philosophers = new myThread[5];


        // creating the 5 philosophers as 5 different threads
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new myThread();
        }


        ArrayList<Boolean> sticks = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            sticks.add(false);
        }

        System.out.println(sticks);
//        for(int i = 0; i < list.size(); i++){
//            print(list.get(i));
//        }


    }

}