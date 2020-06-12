package com.atguigu.Algorithm.kruskal;

import java.util.Arrays;

public class KruskalCase {
    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs,matrix);
        kruskalCase.print();
   /*     EData[] edges = kruskalCase.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println(Arrays.toString(edges));*/
        kruskalCase.kruskal();

    }

    public void kruskal(){
        int index =0;//最后结果数组的索引
        int[] ends =new int[edgeNum];//保存已有最小生成树

        EData[] rets = new EData[edgeNum];

        //获取图中所有集合
        EData[] edges = getEdges();
        //System.out.println(Arrays.toString(edges)+edges.length);
        //按照权值排序
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树中，判断是准备加入的边是否构成回路，如果么有，
        //就加入rets，否则不能加入
        for (int i =0;i<edgeNum;i++){
            //获取第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第i条边的第二个顶点‘
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树中的重点
            int m = getEnd(ends, p1);
            //
            //获取p2这个顶点在已有最小生成树中的重点
            int n = getEnd(ends,p2);
            //是否构成回路
            if (m!=n){
                //没有构成回路
                ends[m]=n;//设置m在已有最小生成树中的终点
                rets[index++]=edges[i];//有一条边加入rets
            }
        }
        System.out.println("输出最小生成树");
        for (int j = 0; j < index; j++) {
            System.out.println(rets[j]);
        }
    }

    public KruskalCase(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i =0;i<vlen;i++){
                this.vertexs[i]=vertexs[i];
        }
        this.matrix=new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }

        //统计边数
        for (int i =0;i<vlen;i++){
            for (int j = i+1;j<vlen;j++){
                if (this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }

    }

    public void print(){
        System.out.println("邻接矩阵为");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对权值进行排序
    public void sortEdges(EData[] edges){

        for (int i =0;i<edges.length-1;i++){
            for (int j = 0; j < edges.length-1-i; j++) {
                if (edges[j].weight>edges[j+1].weight){
                    EData eData = edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=eData;
                }
            }
        }
    }
    ////获得顶点的下标
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }
    //获取图中的边，放入EData数组中
    public EData[] getEdges(){
        int index =0;
        EData[] edges = new EData[edgeNum];

        for (int i=0;i<vertexs.length;i++){
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j]!=INF){
                    edges[index]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                    index++;
                }
            }
        }
        return edges;
    }

    //判断终点
    public int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }
}

//实例对象就是一条边
class EData{
    char start;
    char end;
    int weight;

    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "[<" +
                "" + start +
                "," + end +
                ">" + weight +
                ']';
    }
}