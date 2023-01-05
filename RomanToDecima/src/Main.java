import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(fromRomanNumber("XC"));
    }
    static Map<Character,Integer> valueMap=
            Map.of('I',1,'V',5,'X',10,'L',50,
                    'C',100,'D',500,'M',1000);


    static int fromRomanNumber(final String romanNumber){
        int value=0;
        int lastDigitValue=0;
        for (int i = romanNumber.length()-1; i >=0; i--) {
            final char romanDigit = romanNumber.charAt(i);
            final int digitValue =valueMap.getOrDefault(romanDigit,0);
            final boolean addMode=digitValue>=lastDigitValue;
            if(addMode){
                value+=digitValue;
                lastDigitValue=digitValue;
            }else{
                value-=digitValue;
            }

        }
        return value;
    }

}