import java.util.List;

public class Main {
   /* static Map<Integer, String> MattParkerMap;
    static Map<Integer,Integer> startPointHopsToMap;
    static List<Integer> path;
    static List<List<Integer>> poolOfPathsForEveryNumber;*/

    public static void main(String[] args)  {

     /*   MattParker m = new MattParker();
        MattParkerMap = m.getMap();
        startPointHopsToMap = new HashMap<>();

        path = new ArrayList<>();
        poolOfPathsForEveryNumber = new ArrayList<>();

        calculateChain();

        *//*System.out.println("start to hop: ");
        for(int i=0;i<=startPointHopsToMap.size();i++){
            System.out.printf("%d = %d%n",i,startPointHopsToMap.get(i));
        }*//*
        // TODO: 28/7/2020 create Chains
        //  todo Calculate the Longest And Shortest ONE
        Thread.sleep(2000);*/

        MattParker parker = new MattParker();
        parker.calculateChain(32);
        List<List<Integer>> poolOfPathsForEveryNumber = parker.getPoolOfPathsForEveryNumber();
        System.out.println(poolOfPathsForEveryNumber);

    }
}
