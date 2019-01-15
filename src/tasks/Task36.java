package tasks;

import tasks.Task34.Pair;


public class Task36 implements TasksMainMethod {
    @Override
    public void run() {
        //instances of generics types are raw(not parametrized)
        Pair p = new Pair<>("F", "S");

        if(p instanceof Pair){
            System.out.println("1");
        }

        //generics objects array
        Pair<String> another = (Pair<String>)p;

        Pair<String>[] arr = (Pair<String>[])new Pair<?>[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = new  Pair<String>();
        }
        arr[0].first = "at";
        arr[0].second = "once";

        arr[2].second = "good!";

        for(int i=0; i<3; i++){
            System.out.println(arr[i].first + " " + arr[i].second);
        }
    }



}
