package misc.lc146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

// 用计数法来判定最久没有访问是错误的
class LRUCache1 {
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> times;
    private int cap;
    public LRUCache1(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        times = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Integer val = times.get(key);
        val++;
        times.put(key, val++);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.size() == 0) {
            cache.put(key, value);
            times.put(key, 1);
            return;
        }
        if (!isFull(cache)) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                Integer val = times.get(key);
                val++;
                times.put(key, val);
                return;
            }
            dec(times);
            cache.put(key, value);
            times.put(key, 1);
            return;
        }
        int min = Integer.MAX_VALUE;
        int min_key = 0;
        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                min_key = entry.getKey();
            }
        }
        cache.remove(min_key);
        times.remove(min_key);
        dec(times);
        cache.put(key, value);
        times.put(key, 1);
    }

    private boolean isFull(Map<Integer, Integer> cache) {
        return cache.size() == cap;
    }

    public static void show(LRUCache1 lruCache) {
        System.out.println(lruCache.cache);
    }

    private void dec(Map<Integer, Integer> times) {
        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            Integer val = entry.getValue();
            val--;
            times.put(entry.getKey(), val);
        }
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);

        show(lruCache);
    }
}

