package algo.sort;

import algo.objects.Vertex;
import algo.search.DFS;

import java.util.HashMap;
import java.util.LinkedList;

public class TopologicalSort {
    public LinkedList sort(HashMap<Vertex, LinkedList<Vertex>> g) {
        DFS.search(g);
        return DFS.topoSortList;
    }
}
