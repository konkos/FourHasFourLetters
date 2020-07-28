import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, String> MattParkerMap;
    static Map<Integer,Integer> startPointHopsToMap;

    public static void main(String[] args) {

        MattParker m = new MattParker();
        MattParkerMap = m.getMap();
        startPointHopsToMap = new HashMap<>();

        int pos, hop;
        for(int i=1;i<70;i++){
            pos = i;
            hop = calculateHop(pos);
            startPointHopsToMap.put(pos,hop);
        }

        System.out.println("start to hop: ");
        for(int i=0;i<=startPointHopsToMap.size();i++){
            System.out.println(String.format("%d = %d",i,startPointHopsToMap.get(i)));
        }
        // TODO: 28/7/2020 create Chains
        //  todo Calculate the Longest And Shortest ONE
    }

    private static int calculateHop(int pos){
        //System.out.println("starting point: " + MattParkerMap.get(pos));
        String string = MattParkerMap.get(pos);
        int length = string.length();
        //System.out.println("hop point:" + MattParkerMap.get(length));
        return length;
    }
}
