package zhaohangkazhongxin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        
        Scanner scanner = new Scanner(System.in);
        int a =scanner.nextInt();
        for(int i=0;i<a;i++){
            int n=scanner.nextInt();
            Wood[] ws = new Wood[n];
            for(int j=0;j<n;j++){
                ws[j]=new Wood(scanner.nextInt(),scanner.nextInt());
            }
            Arrays.sort(ws);

            int t =0;
            int nl;
            int nw;
            for(int k=0;k<n;k++){
                if(ws[k].judge==1){
                    continue;
                }
                nl=ws[k].l;
                nw=ws[k].w;
                t++;
                for(int j=k+1;j<n;j++){
                    if(ws[j].w>=nw && ws[j].judge==0){
                        nl=ws[j].l;
                        nw=ws[j].w;
                        ws[j].setJudge();
                    }
                }
            }
            System.out.println(t);

        }
    }
}
class Wood implements Comparable<Wood>{
    int l;
    int w;
    int judge=0;
    public Wood(int l,int w){
        this.l=l;
        this.w=w;
    }
    public void setJudge(){
        this.judge=l;
    }

    @Override
    public int compareTo(Wood o) {
        if(l==o.l){
            return (w>o.w)?1:-1;
        }
        return (l>o.l)?1:-1;
    }
}
