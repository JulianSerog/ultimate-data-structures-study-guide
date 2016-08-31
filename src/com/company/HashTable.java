package com.company;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by richardsaney on 8/29/16.
 */
public class HashTable<K extends Comparable<K>, V> extends AbstractMap<K,V> {

    HashEntry[] table;
    int size = 0;
    final int initialTableSize;

    class HashEntry
    {
        TreeMap<K,V> map = new TreeMap<K, V>();
    }

    public HashTable()
    {
        this(31);
    }

    @SuppressWarnings("unchecked")
    protected HashTable(int tableSize)
    {
        this.initialTableSize = tableSize;
        final HashEntry[] table = (HashEntry[]) Array.newInstance(HashEntry.class, tableSize);
        this.table = table;
        for(int i = 0; i < table.length; i++)
        {
            table[i] = new HashEntry();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null) throw new NullPointerException();
        int index = hashIndex(((K) key).hashCode());
        return table[index].map.containsKey(key);
    }


    //O(n) time, a full table scan since no key is given
    @Override
    public boolean containsValue(Object value) {
        if(value == null) throw new NullPointerException();
        for(HashEntry entry : table)
        {
            if(entry.map.containsValue(value))
                return true;
        }
        return false;
    }

    @Override
    public V put(K key, V value)
    {
        if(value == null) throw new NullPointerException();
        int index = hashIndex(key.hashCode());
        if(table[index] == null) {
            table[index] = new HashEntry();
        }
        table[index].map.put(key,value);
        size++;
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().stream().forEach(
                pair -> this.put(pair.getKey(), pair.getValue()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        final HashEntry[] table = (HashEntry[]) Array.newInstance(HashEntry.class, this.initialTableSize);
        for(int i = 0; i < table.length; i++)
        {
            table[i] = new HashEntry();
        }
        this.table = table;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        for(HashEntry entry : table)
        {
            keys.addAll(entry.map.keySet());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new TreeSet<>();
        for(HashEntry entry : table)
        {
            values.addAll(entry.map.values());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new LinkedHashSet<>();
        for(HashEntry entry : table)
        {
            entry.map.entrySet().stream().forEach(
                    pair -> entries.add(pair)
            );

        }
        return entries;
    }

    @Override
    public V get (Object key)
    {
        int index = hashIndex(key.hashCode());
        HashEntry entry = table[index];
        return entry.map.get(key);
    }

    @Override
    public V remove (Object key)
    {
        int index = hashIndex(key.hashCode());
        HashEntry entry = table[index];
        V value = entry.map.remove(key);
        size--;
        return value;
    }

    int hashIndex(int hashcode)
    {
        hashcode ^= (hashcode >>> 20) ^ (hashcode >>> 12);
        hashcode = hashcode ^ (hashcode >>> 7) ^ (hashcode >>> 4);
        return Math.abs(hashcode % this.table.length);
    }

    @Override
    public String toString()
    {
        return this.entrySet().toString();
    }

}
