package tasks.UTILS;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public Pair(){
        this.first = null;
        this.second = null;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public T getFirst() {
        return first;
    }
}
