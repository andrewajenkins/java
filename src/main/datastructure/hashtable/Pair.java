package main.datastructure.hashtable;

public class Pair<K,V> {

    private K key;
    private V value;
    protected Pair<K,V> next;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}