package tasks;

public class Task39 implements TasksMainMethod {
    @Override
    public void run() {
        ArrayList<String> al = new ArrayList<>();



        al.set(0, "good");
        al.set(1, "night");
        al.set(2, "bad");
        al.set(3, "morning");
        al.set(4, "programmer");
/*
        System.out.println(al.get(2) + " " + al.get(4));

        al.get(2).concat("hii");

        Object[] arrstr = new Object[3];
        arrstr[0] = new Object();
        arrstr[1] = new Object();
        arrstr[2] = new Object();
        for(Object s : func(arrstr)){ //error : Comparable is needed
            System.out.print(s + " ");
        }
*/
    }

    class ArrayList<E> {
        private E[] elements;

        ArrayList(){
            elements = (E[]) new Object[10];
        }

        public E get(int n) {
            return (E) elements[n];
        }
        public void set(int n, E e){
            elements[n] = e;
        }
    }

    public  static  <T extends Comparable> T[] func(T[] arr){
        T[] mm = arr;
        return arr;
    }
}
