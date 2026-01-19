package software.ulpgc.kata5.architecture.viewmodel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<Integer>{

    private final Map<String, String> labels;

    private final Map<Integer, Integer> value;


    public Histogram(Map<String, String> labels) {
        this.labels = labels;
        this.value = new HashMap<>();
    }

    public void add(int d){
        this.value.put(d, count(d) + 1);

    }

    public int count(int d) {
        return value.getOrDefault(d, 0);
    }

    public int size(){
        return value.size();
    }

    public boolean isEmpty(){
        return value.isEmpty();
    }

    @Override
    public Iterator<Integer> iterator() {
        return value.keySet().iterator();
    }

    public String title(){
        return labels.getOrDefault("title", "");
    }

    public String x(){
        return labels.getOrDefault("x", "");
    }

    public String y(){
        return labels.getOrDefault("y", "");
    }

    public String legend(){
        return labels.getOrDefault("legend", "");
    }


}
