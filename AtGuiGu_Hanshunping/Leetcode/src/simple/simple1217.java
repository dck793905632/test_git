package simple;

public class simple1217 {
    public int minCostToMoveChips(int[] chips) {
        int m=0;
        int n=0;
        for(int i =0 ;i<chips.length;i++){
            if(chips[i]%2==0){
                m++;
            }else{
                n++;
            }
        }
        if(m>n){
            return n;
        }else{
            return m;
        }
    }
}
