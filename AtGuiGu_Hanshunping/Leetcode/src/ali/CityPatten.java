package ali;

import org.junit.Test;

import java.util.*;

public class CityPatten {

    @Test
    public void test(){
        String pattern = "abba";
        String str = "北京 杭州 杭州 北京";
        boolean b = wordPattern(pattern, str);
        System.out.println(b);
    }
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        char[] pat = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(pat.length!=strs.length){
            return false;
        }
        for(int i=0;i<pat.length;i++){
            if(!map.containsKey(pat[i]) && !map.containsValue(strs[i])){
                map.put(pat[i],strs[i]);
            }else{
                String val =map.get(pat[i]);
                if(val==null){
                    return false;
                }
                if(!map.get(pat[i]).equals(strs[i])){
                    return false;
                }else{
                    continue;
                }
            }

        }
        return true;
    }


}
