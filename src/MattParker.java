import java.util.HashMap;
import java.util.Map;

public class MattParker {
    private Map<Integer,String> numbers;
    private final int LIMIT =  70;

    public MattParker(){
        numbers = new HashMap<>();
        //Manually create the Basic Numbers
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
        
        //Assemble The Rest Using The Basic Numbers
        for(int i = 13; i < LIMIT; i++){
            numbers.put(i, convertIntToWord(i));
        }
    }

    public Map<Integer, String> getMap(){
        return numbers;
    }

    public String convertIntToWord(int number){
        String tensString= "", unitsString = "";
        int tensInt = 0;
        int unitsInt = 0;

        if(number < 12)
            return null;


        if(number > 12 && number < 100){
            tensInt = number / 10;
            unitsInt = number % 10;

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
        return tensString.concat(unitsString);
    }
}
