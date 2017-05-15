package algo.objects;

public class LinkedList {

    int[] a = new int[256];

    Node head;
    Node nil; //l.nil.next == head, l.nil.pref == tail

    public static void listInsertSentinel(LinkedList l, Node x) {
        x.next = l.nil.next;
        l.nil.next.prev = x;
        l.nil.next = x;
        x.prev = l.nil;
    }

    public static Node listSearchSentinel(LinkedList l, int k) {
        Node x = l.nil.next;
        while(x != l.nil && x.key != k) {
            x = x.next;
        }
        return x;
    }

    public static void listDeleteSentinel(LinkedList l, Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    public static void listDelete(LinkedList l, Node x) {
        if(x.prev != null) {
            x.prev.next = x.next;
        } else {
            l.head = x.next;
        }
        if(x.next != null) {
            x.next.prev = x.prev;
        }
    }

    public static void listInsert(LinkedList l, Node x) {
        x.next = l.head;
        if(l.head != null) {
            l.head.prev = x;
        }
        l.head = x;
        x.prev = null;
    }

    public static Node listSearch(LinkedList l, int k) {
        Node x = l.head;
        while(x != null && x.key != k) {
            x = x.next;
        }
        return x;
    }
}
