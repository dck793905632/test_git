package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class medium49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                map.put(key,list);
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
