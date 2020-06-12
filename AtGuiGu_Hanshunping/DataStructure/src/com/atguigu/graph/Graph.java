package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//邻接矩阵
    private int numOfEdges;//边的个数
    private boolean[] isVisited;
    public static void main(String[] args) {
        int n=5;
        String Vertexs[]={"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertexs) {
            graph.insertVextex(vertex);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
       // graph.dfs();
        graph.bfs();
    }

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    //获得第一个邻接节点的下标，否则返回-1
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    //获得下一个邻接节点的下标
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }
    //深度遍历
    public void dfs(boolean[] isVisited,int i){
        //首先输出访问的该节点
        System.out.println(getValueByIndex(i)+"->");
        //将节点设置为已经访问
        isVisited[i]=true;
        //查找节点的第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs重载，遍历所有节点
    public void dfs(){
        //isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVextex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //广度
    public void bfs(boolean[] isVisited,int i){
        int u;//表示队列头结点对应的下标
        int w;//邻接节点w
        //队列，记录访问顺序
        LinkedList<Integer> queue =new LinkedList();
        //访问节点，输出节点信息
        System.out.println(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.add(i);

        while (!queue.isEmpty()){
            //取出队列头
            u = queue.removeFirst();
            //得到第一个邻接矩阵下标
            w = getFirstNeighbor(u);
            while (w!=-1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"=>");
                    //标记已访问
                    isVisited[w] =true;
                    //入队
                    queue.add(w);
                }
                //以u为前驱节点，找w后面的下一个邻接点
                w=getNextNeighbor(u,w);
            }
        }
    }
    public void bfs(){
        for (int i = 0; i < getNumOfVextex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
    //图中常用的算法
    //返回节点的个数
    public int getNumOfVextex(){
        return vertexList.size();
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //范围v1 v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入节点
    public void insertVextex(String vextex){
        vertexList.add(vextex);
    }
    //添加边
    public void  insertEdge(int v1,int v2 ,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }


}
