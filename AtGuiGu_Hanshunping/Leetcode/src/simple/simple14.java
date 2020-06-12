package simple;

public class simple14 {
    public static void main(String[] args) {
        String[] strs = {"a"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        int min=compare(strs[0],strs[1]);
        for (int i =1;i<strs.length-1;i++){
            int compare = compare(strs[0], strs[i + 1]);
            if (min>compare){
                min=compare;
            }
        }
        return strs[0].substring(0,min);
    }

    public static int compare(String str1,String str2){
        int i=0;
        int j =0;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        while (i<chars1.length && j<chars2.length){
            if (chars1[i]==chars2[j]){
                i++;
                j++;
            }else {
                //j=chars1.length;
                break;
            }
        }
        return i;
    }
}

