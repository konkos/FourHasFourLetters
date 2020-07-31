import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MattParker {
    private Map<Integer,String> numbers;
    public static final int LIMIT =  100;//TESTED UP TO THIS NUMBER
    private Map<Integer,Integer> startPointHopsToMap;
    private List<Integer> pathList;
    private final List<List<Integer>> poolOfPathsForEveryNumber;

    public MattParker(){
        numbers = new HashMap<>();
        pathList = new ArrayList<>();
        poolOfPathsForEveryNumber = new ArrayList<>();
        //Manually create the Basic Numbers
        initializeMap();

        //Assemble The Rest Using The Basic Numbers
        for(int i = 13; i < LIMIT; i++){
            numbers.put(i, convertIntToWord(i));
        }
    }

    private void initializeMap() {
        numbers.put(1, "ενα");
        numbers.put(2, "δυο");
        numbers.put(3, "τρια");
        numbers.put(4, "τεσσερα");
        numbers.put(5, "πεντε");
        numbers.put(6, "εξι");
        numbers.put(7, "εφτα");
        numbers.put(8, "οχτω");
        numbers.put(9, "εννια");
        numbers.put(10, "δεκα");
        numbers.put(11, "εντεκα");
        numbers.put(12, "δωδεκα");

        numbers.put(20, "εικοσι");
        numbers.put(30, "τριαντα");
        numbers.put(40, "σαραντα");
        numbers.put(50, "πενηντα");
        numbers.put(60, "εξηντα");
        numbers.put(70, "εβδομηντα");
        numbers.put(80, "ογδοντα");
        numbers.put(90, "ενενηντα");

        numbers.put(100, "εκατο");
        numbers.put(200, "διακοσια");
        numbers.put(300, "τριακοσια");
        numbers.put(400, "τετρακοσια");
        numbers.put(500, "πεντακοσια");
        numbers.put(600, "εξακοσια");
        numbers.put(700, "εφτακοσια");
        numbers.put(800, "οκτακοσια");
        numbers.put(900, "εννιακοσια");
        //TODO ADD HUNDREDS AND THOUSANDS
    }

    public Map<Integer, String> getMap(){
        return numbers;
    }

    public List<Integer> getPathList() {return pathList;}

    public List<List<Integer>> getPoolOfPathsForEveryNumber() {return poolOfPathsForEveryNumber;}

    public String convertIntToWord(int number){
        String tensString= "", unitsString = "", hundredsString = "";
        int tensInt;
        int unitsInt;
        int hundredsInt;

        if(number < 12)
            return null;

        if(number >= 100){
            hundredsInt = number / 100;
            number = number % 100;

            switch (hundredsInt){
                case 1:
                    hundredsString = numbers.get(100);break;
                case 2:
                    hundredsString = numbers.get(200);break;
                case 3:
                    hundredsString = numbers.get(300);break;
                case 4:
                    hundredsString = numbers.get(400);break;
                case 5:
                    hundredsString = numbers.get(500);break;
                case 6:
                    hundredsString = numbers.get(600);break;
                case 7:
                    hundredsString = numbers.get(700);break;
                case 8:
                    hundredsString = numbers.get(800);break;
                case 9:
                    hundredsString = numbers.get(900);break;
            }
        }

        if(number > 12){
            tensInt = number / 10;
            unitsInt = number % 10;

            //Simplify using unitsString = numbers.get(unitsInt); Use same scheme for the tens and hundreds !Fails due to weird NullPointerException
            switch (unitsInt){
                case 1:
                    unitsString = numbers.get(1); break;
                case 2:
                    unitsString = numbers.get(2); break;
                case 3:
                    unitsString = numbers.get(3); break;
                case 4:
                    unitsString = numbers.get(4); break;
                case 5:
                    unitsString = numbers.get(5); break;
                case 6:
                    unitsString = numbers.get(6); break;
                case 7:
                    unitsString = numbers.get(7); break;
                case 8:
                    unitsString = numbers.get(8); break;
                case 9:
                    unitsString = numbers.get(9); break;
            }

            switch (tensInt){
                case 1:
                    tensString = numbers.get(10); break;
                case 2:
                    tensString = numbers.get(20); break;
                case 3:
                    tensString = numbers.get(30); break;
                case 4:
                    tensString = numbers.get(40); break;
                case 5:
                    tensString = numbers.get(50); break;
                case 6:
                    tensString = numbers.get(60); break;
                case 7:
                    tensString = numbers.get(70); break;
                case 8:
                    tensString = numbers.get(80); break;
                case 9:
                    tensString = numbers.get(90); break;
            }
        }


        return hundredsString.concat(tensString.concat(unitsString));
    }

    private int calculateHop(int pos){
        String string = numbers.get(pos);
        return string.length();
    }

    public void calculateChain() {
        int pos, hop;
        for(int i=1; i<MattParker.LIMIT; i++){
            pos = i;
            hop = calculateHop(pos);
            do{
                pathList.add(hop);
                hop = calculateHop(hop);
            }while(!pathList.contains(hop));
            poolOfPathsForEveryNumber.add(new ArrayList<>(pathList));
            pathList.clear();

//            startPointHopsToMap.put(pos,hop);
        }
    }

    public List<Integer> calculateLongestChain() {
        int max = 0;
        List<Integer> maxChain = null;
        int index = 0;
        for(List<Integer> list : poolOfPathsForEveryNumber){
            if(list.size() > max){
                max = list.size();
                maxChain = list;
                index++;
            }
        }
        System.out.println("Index of longest chain " + index);
        return maxChain;
    }

    public List<Integer> calculateShortestChain(){
        int min = Integer.MAX_VALUE;
        List<Integer> minChain = null;
        for(List<Integer> list : poolOfPathsForEveryNumber){
            if(list.size() < min){
                min = list.size();
                minChain = list;
            }
        }
        return minChain;
    }

}
