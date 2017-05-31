package main.algo.search;

import java.util.HashMap;
import java.util.LinkedList;

import main.algo.objects.Vertex;

public class DFS {

    public static int time;

    public static LinkedList<Vertex> topoSortList;

    public static void search(HashMap<Vertex, LinkedList<Vertex>> g) {
        for(Vertex u : g.keySet()) {
            u.c = -1;
            u.p = null;
        }
        time = 0;
        for(Vertex u : g.keySet()) {
            if(u.c == -1) {
                visit(g, u);
            }
        }
    }

    public static void visit(HashMap<Vertex, LinkedList<Vertex>> g, Vertex u) {
        time = time + 1;
        u.d = time;
        u.c = 0;
        for (Vertex v : g.get(u)) {
            if (v.c == -1) {
                v.p = u;
                visit(g, v);
            }
        }
        u.c = 1;
        time++;
        u.t = time;
        topoSortList.add(u);
    }
}
