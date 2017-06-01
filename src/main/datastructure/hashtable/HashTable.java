package main.datastructure.hashtable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * An array based implementation of hash table that supports the same hash table api as Java 7
 */
public class HashTable<K,V> implements Serializable, Cloneable, Map<K,V>{

    private static final long serialVersionUID = 1L;
    private ArrayList<Pair<K,V>> table;
    private int initialCapacity = 11;
    private float loadFactor = .75f;
    

    /**
     * Constructs a new, empty hashtable with a default initial capacity (11) and load factor (0.75).
     */
    public HashTable() {
        this.table = new ArrayList<Pair<K,V>>(initialCapacity);
        this.loadFactor = loadFactor;
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and default load factor (0.75).
     * @param initialCapacity
     */
    public HashTable(int initialCapacity) {
        throw new UnsupportedOperationException();
    }

    /**
     * Constructs a new, empty hashtable with the specified initial capacity and the specified load factor.
     * @param initialCapacity
     * @param loadFactor
     */
    public HashTable(int initialCapacity, float loadFactor) {
        throw new UnsupportedOperationException();
    }

    /**
     * Constructs a new hashtable with the same mappings as the given Map.
     * @param m
     */
    public HashTable(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    /**
     * Clears this hashtable so that it contains no keys.
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a shallow copy of this hashtable.
     */
    public Object clone() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(Object key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the hash code value for this Map as per the definition in the Map interface.
     */
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    /**
     * Tests if this hashtable maps no keys to values.
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an enumeration of the keys in this hashtable.
     */
    public Enumeration<K> keys() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    public V put(K key, V value) {
        Pair<K,V> e = new Pair<K,V>(key, value);
        if(table.isEmpty()) {
            table.add(e);
            return value;
        } else {
            Pair<K,V> current = table.get(0);
            while(current.next != null) {
                current = current.next;
            }
            current.next = e;
            table.add(0,e);
        }
        return value;
    }

    /**
     * Copies all of the mappings from the specified map to this hashtable.
     */
    public void putAll(Map<? extends K, ? extends V> t) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the number of keys in this hashtable
     */
    public int size() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

}