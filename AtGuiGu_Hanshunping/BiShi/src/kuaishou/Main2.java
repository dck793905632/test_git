package kuaishou;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        List<String> lianghao = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            int shun = shunzi(strs[i]);
            int bao = baozi(strs[i]);
            if(shun>=3 || bao>=3){
                lianghao.add(strs[i]);
            }
        }
        String ssss ="";
       for(int i=0;i<lianghao.size();i++){
           ssss+=lianghao.get(i)+" ";
       }
        System.out.println(ssss.trim());



    }
    public static int shunzi(String str){
        String s = str.substring(3,str.length());
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            nums[i]=chars[i]-'0';
        }
        int max = 0;
        int up=0;
        int down=0;
        for(int i =1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                up++;
            }else {
                up=0;
            }
            if(nums[i]==nums[i-1]-1){
                down++;
            }else {
                down=0;
            }
            max=Math.max(up,down);
        }
        return max;

    }
    public static int baozi(String str){
        char[] chars = str.toCharArray();
        int j=3;
        int max=0;
        int count=0;
        for(int i=3;i<chars.length;i++){
            if(chars[j]==chars[i]){
                max++;
            }else {
                j=i;
                count=max;
                max=0;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
