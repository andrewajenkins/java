package main.algo.objects;

public class ChainedHashTable {

    private static LinkedList[] table = new LinkedList[256];

    public void chainedHashInsert(ChainedHashTable t, int x) {
        LinkedList.listInsert(t.table[h(x)], new Node(x));
    }

    public boolean chainedHashSearch(ChainedHashTable t, int k) {
        LinkedList list = t.table[h(k)];
        Node node = list.head;
        while(node.next != null) {
            if(node.key == k) return true;
            node = node.next;
        }
        return false;
    }

    public void chainedHashDelete(ChainedHashTable t, int k) {
        LinkedList list = t.table[h(k)];
        LinkedList.listDelete(list, new Node(k));
    }

    public static int h(int k) {
        return divisionHash(k);
    }

    public static int divisionHash(int k) {
        return k % table.length;
    }

    public static int multiplicationHash(int k) {
        int result = 17;
        result = 31 * result + k;
        return result % table.length;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 256; i++) {
            System.out.println(multiplicationHash(i));
        }
    }
}