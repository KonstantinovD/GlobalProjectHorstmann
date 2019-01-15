package tasks;

//Horstmann page 318
//StaticInnerClass

public class Task24 implements TasksMainMethod {
    @Override
    public void run() {
        ArrayAlg.Pair p = new ArrayAlg.Pair(12.4, 71.8);
        p.setSecond(p.getFirst()+1.0);

        System.out.print(p.getFirst() + " "+ p.getSecond());
    }
}

class ArrayAlg
{

    /**
     * A pair of floating-point numbers
     */
    public static class Pair
    {
        private double first;
        private double second;

        /**
         * Constructs a pair from 2 floating-point numbers
         * @param first the first number
         * @param second the second number
         */
        public Pair(double first, double second){
            this.first = first;
            this.second = second;
        }

        /**
         * Returns the first number of the pair
         * @return the first number
         */
        public double getFirst(){
            return first;
        }

        /**
         * Returns the second number of the pair
         * @return the second number
         */
        public double getSecond(){
            return second;
        }

        /**
         * Sets the first number of the pair
         * @param first the first number
         */
        public void setFirst(double first) {
            this.first = first;
        }

        /**
         * the second number of the pair
         * @param second the second number
         */
        public void setSecond(double second) {
            this.second = second;
        }
    }
}