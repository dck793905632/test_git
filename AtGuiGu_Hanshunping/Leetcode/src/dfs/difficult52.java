package dfs;

import java.util.ArrayList;
import java.util.List;

public class difficult52 {
    int count=0;
    public int totalNQueens(int n) {
        List<Integer> cols = new ArrayList<>();
        dfs(n,cols);
        return count;
    }
    public void dfs (int n,
                     List<Integer> cols){
        if(cols.size()==n){
            count++;
            return;
        }
        for(int colIndex=0;colIndex<n;colIndex++){
            if(!isVaild(cols,colIndex)){
                continue;
            }
            cols.add(colIndex);
            dfs(n,cols);
            cols.remove(cols.size()-1);
        }

    }
    public boolean isVaild(List<Integer> cols,int column){
        int row =cols.size();
        for(int rowIndex=0;rowIndex<cols.size();rowIndex++){
            if(cols.get(rowIndex)==column){
                return false;
            }
            if(rowIndex+cols.get(rowIndex)==row+column){
                return false;
            }
            if(rowIndex-cols.get(rowIndex)==row-column){
                return false;
            }
        }
        return true;
    }
}
