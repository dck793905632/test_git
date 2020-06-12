package gcd;

import org.junit.Test;

public class simple914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for(int i=0;i<deck.length;i++){
            count[deck[i]]++;
        }
        int cur = count[deck[0]];
        for(int i=0;i<10000;i++){
            if(count[i]==1){
                return false;
            }
            if(count[i]>1){
                cur = gcd(cur,count[i]);
                if(cur==1){
                    return false;
                }
            }

        }
        return true;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
