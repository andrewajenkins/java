package main.algo.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import main.algo.objects.Vertex;

public class BFS {
    public void search(HashMap<Vertex, LinkedList<Vertex>> g, Vertex s) {
        for(Vertex u : g.keySet()) {
            u.c = -1;
            u.d = -1;
            u.p = null;
        }
        s.c = 0;
        s.d = 0;
        s.p = null;
        Queue<Vertex> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            Vertex u = q.poll();
            for(Vertex v : g.get(u)) {
                if(v.c == -1) {
                    v.c = 0;
                    v.d = u.d+1;
                    v.p = u;
                    q.add(v);
                }
            }
            u.c = 1;
        }
    }

    public void printPath(HashMap<Vertex, LinkedList<Vertex>> g, Vertex s, Vertex v) {
        if(v.equals(s)) {
            System.out.println(s);
        } else if(v.p == null) {
            System.out.println("no path from s to v exists");
        } else {
            printPath(g, s, v.p);
        }
    }
}
