import java.util.List;

public class Main {


    public static void main(String[] args)  {

        MattParker parker = new MattParker();
        parker.calculateChain();
        List<List<Integer>> poolOfPathsForEveryNumber = parker.getPoolOfPathsForEveryNumber();
        System.out.println(poolOfPathsForEveryNumber);

        List<Integer> integers = parker.calculateLongestChain();
        System.out.println("LONGEST CHAIN: " + integers);
        System.out.println("SIZE: " + integers.size());

        List<Integer> integers2 = parker.calculateShortestChain();
        System.out.println("SHORTEST CHAIN: " + integers2);
        System.out.println("SIZE: " + integers2.size());

    }
}
