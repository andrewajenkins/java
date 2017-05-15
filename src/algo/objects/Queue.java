package algo.objects;

public class Queue {

    int[] a = new int[256];

    int tail = 0;

    int head = 0;

    public static void enqueue(Queue q, int x) {
        q.a[q.tail] = x;
        if(q.tail == q.a.length) {
            q.tail = 1;
        } else {
            q.tail++;
        }
    }

    public static int dequeue(Queue q) {
        int x = q.a[q.head];
        if(q.head == q.a.length) {
            q.head = 1;
        } else {
            q.head++;
        }
        return x;
    }
}
