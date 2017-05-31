package main.algo.objects;

public class StorageManager {

    Node free;

    public Node allocateObject() {
        if(free == null) {
            throw new RuntimeException("error out of space");
        } else {
            Node x = free;
            free = x.next;
            return x;
        }
    }

    public void freeObject(Node x) {
        x.next = free;
        free = x;
        x = null; //java garbage collection trigger
    }
}
