package meituan;

import java.util.Scanner;

public class Main82201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for(int i=0;i<c;i++){
            String str = scanner.next();
            System.out.println(check(str));
        }
    }
    public static String check(String str){
        if(check1(str)&&check2(str)&& check3(str)){
            return "Accept";
        }else{
            return "Wrong";
        }
    }
    public static boolean check1(String str){
        if((str.charAt(0)>='a' && str.charAt(0)<='z')
                ||(str.charAt(0)>='A' && str.charAt(0)<='Z')){
            return true;
        }else{
            return false;
        }
    }
    public static boolean check2(String str){
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if((chars[i]<'a' || chars[i]>'z') &&
                    (chars[i]<'A' || chars[i]>'Z') &&
                    (chars[i]<'0' || chars[i]>'9')){
                return false;
            }
        }
        return true;
    }
    public static boolean check3(String str){
        char[] chars = str.toCharArray();
        int num=0;
        int strc=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0' && chars[i]<='9'){
                num++;
            }else {
                strc++;
            }
        }
        if(num<chars.length && num!=0){
            return true;
        }else {
            return false;
        }
    }
}
