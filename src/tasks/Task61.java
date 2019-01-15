package tasks;

import java.util.BitSet;

public class Task61 implements TasksMainMethod {
    @Override
    public void run() {


        BitSet bs_1 = new BitSet(3) {
            @Override
            public String toString() {
                String res = "[";
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i)) {
                        res += "1 ";
                    } else {
                        res += "0 ";
                    }
                }
                if (size() > 0) {
                    if (this.get(this.size() - 1)) {
                        res += "1]";
                    } else {
                        res += "0]";
                    }
                }
                return res;
            }
        };
        BitSet bs_2 = new BitSet(3);
        BitSet bs_3 = new BitSet(3);


        bs_1.set(1);
        bs_1.set(2);

        bs_2.set(2, true);
        System.out.println(bs_1);

        //bs_1.toString();

        bs_1.and(bs_2);

        System.out.println(bs_1);
        System.out.println(bs_2);

        //EXAMPLE FROM INTERNET
        System.out.println("__________________________________");

        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
// set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);
// AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);
// OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);
// XOR bits
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }
}

