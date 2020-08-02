import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 1/8/2020 add support for english
// TODO: 1/8/2020 add support for numbers higher than 9999
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
        numbers.put(0, "");
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

        numbers.put(1000, "χιλια");//for 1000->1999
        numbers.put(-1000, "χιλιαδες");//suffix for 2000->9999
    }

    public Map<Integer, String> getMap(){
        return numbers;
    }

    public List<Integer> getPathList() {return pathList;}

    public List<List<Integer>> getPoolOfPathsForEveryNumber() {return poolOfPathsForEveryNumber;}

    public String convertIntToWord(int number){
        String tensString= "", unitsString = "", hundredsString = "", thousandsString="";
        int tensInt, unitsInt, hundredsInt, thousandsInt;

        if(number < 12)
            return null;

        if(number >= 1000){
            thousandsInt = number / 1000;
            number = number % 1000;

            /*e.g 2 xiliades ... => numbers.get(2) + "xiliades" + ...
            * BROKEN*/
            switch (thousandsInt){
                case 1:
                    thousandsString = numbers.get(1000);break;
                case 2:
                    thousandsString = numbers.get(2);break;
                case 3:
                    thousandsString = numbers.get(3);break;
                case 4:
                    thousandsString = numbers.get(4);break;
                case 5:
                    thousandsString = numbers.get(5);break;
                case 6:
                    thousandsString = numbers.get(6);break;
                case 7:
                    thousandsString = numbers.get(7);break;
                case 8:
                    thousandsString = numbers.get(8);break;
                case 9:
                    thousandsString = numbers.get(9);break;

            }
            if(thousandsInt!= 1)
                thousandsString = thousandsString + " " + numbers.get(-1000);
        }

        if(number >= 100){
            hundredsInt = number / 100;
            number = number % 100;

            hundredsString = numbers.get(hundredsInt * 100);
        }

        if(number > 12){
            tensInt = number / 10;
            unitsInt = number % 10;

            unitsString = numbers.get(unitsInt);

            //Simplify using tensString = numbers.get(tensInt); !Fails due to weird NullPointerException -- 0 is not set
            tensString = numbers.get(tensInt * 10);
        }


        return thousandsString.concat(hundredsString.concat(tensString.concat(unitsString)));
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
