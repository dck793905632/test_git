package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class simple804 {
    public static void main(String[] args) {
        String[] words={"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] strTable={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        //Map<String,Integer> map = new HashMap<>();
        String str="";
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words[i].length();j++){
                str+=strTable[words[i].charAt(j)-97];
            }
            //map.put(str,0);
            set.add(str);
            str="";
        }


        return set.size();
    }
}
