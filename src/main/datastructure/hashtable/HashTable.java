package main.datastructure.hashtable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * An array based implementation of hash table that supports the same hash table api as Java 7
 */
public class HashTable<K,V> implements Serializable, Cloneable, Map<K,V>{

    private static final long serialVersionUID = 1L;
    private ArrayList<LinkedList<Pair<K,V>>> table;
    private ArrayList<K> keys;
    private ArrayList<V> values;
    private int capacity = 11;
    private float loadFactor = .75f;
    private int size = 0;
    

    /**
     * Constructs a new, empty hashtable with a default initial capacity (11) and load factor (0.75).
     */
    public HashTable() {
        this(11);
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and default load factor (0.75).
     * @param initialCapacity
     */
    public HashTable(int initialCapacity) {
        this(initialCapacity, .75f);
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and the specified load factor.
     * @param initialCapacity
     * @param loadFactor
     */
    public HashTable(int initialCapacity, float loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.table = new ArrayList<LinkedList<Pair<K,V>>>(initialCapacity);
        this.keys = new ArrayList<K>();
        this.values = new ArrayList<V>();
        for(int i = 0; i < initialCapacity; i++) {
            table.add(new LinkedList<Pair<K,V>>());
        }
        this.loadFactor = loadFactor;
    }

    /**
     * Constructs a new hashtable with the same mappings as the given Map.
     * @param m
     */
    public HashTable(Map<? extends K, ? extends V> m) {
        this();
        Set<? extends K> keySet = m.keySet();
        for(K key : keySet) {
            put(key, m.get(key));
        }
    }

    /**
     * Clears this hashtable so that it contains no keys.
     */
    public void clear() {
        this.table = new ArrayList<LinkedList<Pair<K,V>>>(table.size());
        this.keys = new ArrayList<K>();
        this.values = new ArrayList<V>();
        size = 0;
    }

    /**
     * Creates a shallow copy of this hashtable.
     */
    public Object clone() {
        return this.clone();
    }

    /**
     * Tests if some key maps into the specified value in this hashtable
     */
    public boolean contains(Object value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Tests if the specified object is a key in this hashtable.
     */
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    /**
     * Returns an enumeration of the values in this hashtable.
     * @param <V>
     * @return
     */
    public Enumeration<V> elements() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a Set view of the mappings contained in this map.
     * @return
     */
    public Set<Map.Entry<K,V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * Compares the specified Object with this Map for equality, as per the definition in the Map interface.
     */
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof HashTable)) {
            return false;
        }

        HashTable<K,V> ht = (HashTable<K,V>) o;

        if(!ht.keySet().equals(this.keySet())) {
            return false;
        }

        for(K key : ht.keySet()) {
            if(!ht.get(key).equals(this.get(key))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(Object key) {
        int index = Math.abs(key.hashCode() % capacity - 1);
        LinkedList<Pair<K,V>> list = table.get(index);
        for(int i = 0; i < list.size(); i++) {
            Pair<K,V> p = list.get(i);
            if(p.getKey().equals(key)) {
                return p.getValue();
            }
        }
        return null;
    }

    /**
     * Returns the hash code value for this Map as per the definition in the Map interface.
     */
    public int hashCode() {
        return this.hashCode();
    }

    /**
     * Tests if this hashtable maps no keys to values.
     */
    public boolean isEmpty() {
        return table.isEmpty();
    }

    /**
     * Returns an enumeration of the keys in this hashtable.
     */
    public Enumeration<K> keys() {
        return new Vector<K>(this.keys).elements();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public Set<K> keySet() {
        return new HashSet<K>(keys);
    }

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    public V put(K key, V value) {
        Pair<K,V> e = new Pair<K,V>(key, value);
        int index = Math.abs(key.hashCode() % capacity - 1);
        System.out.println(index + " " + e.hashCode());
        remove(key);
        table.get(index).add(e);
        printTable();
        keys.add(key);
        values.add(value);
        size++;
        return value;
    }

    /**
     * Copies all of the mappings from the specified map to this hashtable.
     */
    public void putAll(Map<? extends K, ? extends V> t) {
        Set<? extends K> set = t.keySet();
        for(K key : set) {
            V value = t.get(key);
            put(key, value);
            keys.add(key);
            values.add(value);
            size++;
        }
    }

    /**
     * Increases the capacity of and internally reorganizes this hashtable, in order to accommodate and access its entries more efficiently.
     */
    protected void rehash() {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the key (and its corresponding value) from this hashtable.
     */
    public V remove(Object key) {
        int index = Math.abs(key.hashCode() % capacity - 1);
        LinkedList<Pair<K,V>> list = table.get(index);
        for(int i = 0; i < list.size(); i++) {
            Pair<K,V> p = list.get(i);
            if(p.getKey().equals(key)) {
                list.remove(i);
                keys.remove(key);
                values.remove(p.getValue());
                size--;
                printTable();
                return p.getValue();
            }
        }
        printTable();
        return null;
    }

    /**
     * Returns the number of keys in this hashtable
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this Hashtable object in the form of a set of entries, enclosed in braces and separated by the ASCII characters ", " (comma and space).
     */
    public String toString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a Collection view of the values contained in this map.
     */
    public Collection<V> values() {
        return values;
    }

    public void printTable() {
        System.out.println("---------------------------------------");
        for(int i = 0; i < capacity; i++) {
            System.out.print(i + " ");
            LinkedList<Pair<K,V>> list = table.get(i);
            Iterator<Pair<K,V>> it = list.iterator();
            while(it.hasNext()) {
                System.out.print(it.next().getValue() + " ");
            }
            System.out.println();
        }
    }
}