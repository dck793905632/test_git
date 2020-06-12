package graph;

import java.util.*;

public class medium133copyGraph {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        //1 获取所有nodes
        Set<Node> nodes = getNodes(node);
        //2 copy所有nodes
        HashMap<Node,Node> map = new HashMap<>();
        for (Node node1 : nodes){
            map.put(node1,new Node(node1.val));
        }
        //3 获取所有边
        for (Node n :nodes){
            Node newNode = map.get(n);
            for (Node neighbors :n.neighbors){
                Node newNeighbors = map.get(neighbors);
                newNode.neighbors.add(newNeighbors);
            }
        }
        return map.get(node);

    }
    public Set<Node> getNodes(Node node){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node newNode = queue.poll();
            set.add(newNode);
            for(Node neighbor :newNode.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return set;
    }
}
