/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgh_idos;

/**
 *
 * @author semve
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class TGH_Idos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graf = new Graph();
        int stanic = sc.nextInt();
        for(int i = 0; i<stanic;i++){
        graf.addNode(new Node(i+""));
        }
        int spoju = sc.nextInt();
        for(int i = 0; i < spoju;i++){
            int start = sc.nextInt();
            int cil = sc.nextInt();
            int casOdjezdu = sc.nextInt();
            int casCesty = sc.nextInt();
            graf.getNode(start+"").addDestination(graf.getNode(cil+""), casOdjezdu, casCesty);

        }
        int pocetDotazu = sc.nextInt();
        for (int i = 0; i < pocetDotazu; i++){
        int startStanice = sc.nextInt();
        int cilStanice = sc.nextInt();
        int dobaOdjezdu = sc.nextInt();
        
        //TODO Djikstra
        }
    }
    
}

 class Graph {
 
    private Set<Node> nodes = new HashSet<>();
     
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
 
    public Node getNode(String name){
        if (nodes.contains(name)) {
      for (Node obj : nodes) {
        if (obj.equals(name)) 
          return obj;
      } 
   }

  return null;
    }
}

 class Node {
     
    private String name;
     
    private List<Node> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    //Map<Node, Integer> adjacentNodes = new HashMap<>();
    ArrayList<Path> adjacentNodes = new ArrayList<Path>();
    public void addDestination(Node destination, int distance, int time) {
        adjacentNodes.add(new Path(destination, distance, time));
    }
  
    public Node(String name) {
        this.name = name;
    }
     
    // getters and setters
}

class Path{
private Node dest;
private int dist;
private int time;

    public Path(Node dest, int dist, int time) {
        this.dest = dest;
        this.dist = dist;
        this.time = time;
    }

    public Node getDest() {
        return dest;
    }
    /**
     * Vrátí čas cestyy + čekání nebo INT max val, pokud u odjel
     * @param time
     * @return 
     */
    public int getDist(int time) {
        if(time > this.time) return Integer.MAX_VALUE;
        return dist + (this.time - time);
    }
    


}