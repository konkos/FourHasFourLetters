import java.net.Socket;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        MattParker parker = new MattParker();
        parker.calculateChain();
        List<List<Integer>> poolOfPathsForEveryNumber = parker.getPoolOfPathsForEveryNumber();
        System.out.println(poolOfPathsForEveryNumber);
        for(int i=0; i<poolOfPathsForEveryNumber.size(); i++) {
            int j= i+1;
            System.out.println(j + " " + poolOfPathsForEveryNumber.get(i));
        }

        List<Integer> integers = parker.calculateLongestChain();
        System.out.println("LONGEST CHAIN: " + integers);
        System.out.println("SIZE: " + integers.size());

        List<Integer> integers2 = parker.calculateShortestChain();
        System.out.println("SHORTEST CHAIN: " + integers2);
        System.out.println("SIZE: " + integers2.size());

    }
}
