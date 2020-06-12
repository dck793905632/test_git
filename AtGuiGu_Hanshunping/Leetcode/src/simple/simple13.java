package simple;

import sun.util.resources.CalendarData;

import java.util.HashMap;
import java.util.Map;

public class simple13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
//        System.out.println(s.substring(1,2));
        int i = romanToInt(s);
        System.out.println(i);
    }
    public static int romanToInt(String s) {
        String str = s;
        int sum=0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i =0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                sum+=map.get(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length()-1; i++) {

            switch(""+str.charAt(i)+str.charAt(i+1)){
                case "IV":
                    sum-=2;
                    break;
                case "IX":
                    sum-=2;
                    break;
                case "XL":
                    sum-=20;
                    break;
                case "XC":
                    sum-=20;
                    break;
                case "CD":
                    sum-=200;
                    break;
                case "CM":
                    sum-=200;
                default:
                    break;
            }

        }
            return sum;
        }

}
