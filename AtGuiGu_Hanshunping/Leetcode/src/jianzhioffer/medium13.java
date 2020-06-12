package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

public class medium13 {
    int m,n,k;
    boolean[][] vistied ;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        this.vistied= new boolean[m][n];
        return dfs(0,0);
    }
    public int dfs(int i,int j){
        if(i<0 || i>=m || j<0 || j>=n ||sumRes(i,j)>k || vistied[i][j]){
            return 0;
        }
        vistied[i][j]=true;
        return 1+dfs(i+1,j)+dfs(i,j+1);

    }
    public int sumRes(int i,int j){
        int sum=0;
        while(i!=0){
            sum+=i%10;
            i/=10;
        }
        while(j!=0){
            sum+=j%10;
            j/=10;
        }
        return sum;
    }
    /*public int movingCount(int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] vistied = new boolean[m][n];
        vistied[0][0]=true;
        int res =1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int l=0;l<size;l++){
                int[] arr = queue.poll();
                int i=arr[0];
                int j=arr[1];
                if(i+1<m && sumRes(i+1,j)<=k && !vistied[i+1][j]){
                    queue.offer(new int[]{i+1,j});
                    vistied[i+1][j]=true;
                    res++;
                }
                if(j+1<n && sumRes(i,j+1)<=k && !vistied[i][j+1]){
                    queue.offer(new int[]{i,j+1});
                    vistied[i][j+1]=true;
                    res++;
                }
            }
        }
        return res;
    }
    public int sumRes(int i,int j){
        int sum=0;
        while(i!=0){
            sum+=i%10;
            i/=10;
        }
        while(j!=0){
            sum+=j%10;
            j/=10;
        }
        return sum;
    }*/
}
