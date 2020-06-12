package com.atguigu.Algorithm.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MinTree minTree = new MinTree();
        Graph graph = new Graph(verxs);
        minTree.createGraph(graph,verxs,data,weight);
        minTree.showGraph(graph);
        prim(graph,0);
    }

    public static void prim(Graph graph,int v){
        int[] visited = new int[graph.verxs];
        //把当前这个值标记为已访问
        visited[v]=1;
        //记录两个顶点的下标
        int h1 =-1;
        int h2 =-1;
        int minWeight = 10000;
        for (int k=1;k<graph.verxs;k++){//k为边的个数，结束后有graph.verxs-1条边

            for(int i =0 ;i <graph.verxs;i++){//i为访问过的节点
                for (int j =0;j<graph.verxs;j++){//j为未访问的节点
                    if (visited[i]==1 && visited[j]==0 && minWeight>graph.weight[i][j]){
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            System.out.println("<"+graph.data[h1]+","+graph.data[h2]+">"+":"+minWeight);
            minWeight=10000;
            visited[h2]=1;
        }

    }

}

class MinTree{

    //创建邻接矩阵
    public void createGraph(Graph graph,int versx,char[] data,int[][] weight){
        for (int i=0;i<versx;i++){
            graph.data[i]=data[i];
            for (int j=0;j<versx;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    public void showGraph(Graph graph){
        for (int[] link :graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
}

class Graph{
    int verxs;//图的节点数
    char[] data;//存放节点数据
    int[][] weight;//存放边，邻接矩阵
    public Graph(int verxs){
        this.verxs=verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }
}