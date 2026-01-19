package software.ulpgc.kata2.viewmodel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<Integer>{
    private final Map<Integer, Integer> map;


    public Histogram() {
        this.map = new HashMap<>();
    }

    public void add(int d){
        this.map.put(d, count(d) + 1);

    }

    public int count(int d) {
        return map.getOrDefault(d, 0);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }
}
