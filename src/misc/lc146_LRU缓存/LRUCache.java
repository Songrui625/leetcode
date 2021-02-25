package misc.lc146_LRU缓存;

import java.util.*;

class LRUCache {
    private Map<Integer, Integer> cache;
    private List<Integer> arr;
    private int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        arr = new ArrayList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        int idx = arr.indexOf(key);
        arr.remove(idx);
        arr.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.size() == 0) {
            cache.put(key, value);
            arr.add(key);
            return;
        }
        if (cache.size() != cap) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                int idx = arr.indexOf(key);
                arr.remove(idx);
                arr.add(key);
                return;
            } else {
                arr.add(key);
                cache.put(key, value);
                return;
            }
        }
        // cache is full
        if (cache.containsKey(key)) {
            cache.put(key, value);
            int idx = arr.indexOf(key);
            arr.remove(idx);
            arr.add(key);
            return;
        } else {
            int keyToDel = arr.get(0);
            arr.remove(0);
            cache.remove(keyToDel);
            cache.put(key, value);
            arr.add(key);
        }
    }
}
