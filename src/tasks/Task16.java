package tasks;

import java.util.ArrayList;
import java.util.Objects;

public class Task16 implements TasksMainMethod {
    @Override
    public void run() {

        String s1 = "Hi!";

        String s2 = new String("Hi!");

        String s3 = new String(s1);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        s3 = s3.concat(" My name is Danik.");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());


        InnerHash hash_1 = new InnerHash();
        InnerHash hash_2 = new InnerHash();

        System.out.println(Objects.hash(hash_1.var1, hash_1.ob1));
        System.out.println(Objects.hash(hash_2.var1, hash_2.ob1));

        ArrayList<Integer> vector = new ArrayList<>();

        int[] arr = {12, 11, 10, 5, 3, 1, 0};
        print(arr);

    }

    public void print(int... args){
        for(int i:args){
            System.out.print(i + " ");
        }
    }

    class InnerHash{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            InnerHash innerHash = (InnerHash) o;

            if (var1 != innerHash.var1) return false;
            return ob1 != null ? ob1.equals(innerHash.ob1) : innerHash.ob1 == null;
        }

        @Override
        public int hashCode() {



            int result = var1;
            result = 31 * result + (ob1 != null ? ob1.hashCode() : 0);
            return result;
        }

        int var1;
        Object ob1;


    }
}
