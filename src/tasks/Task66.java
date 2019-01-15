package tasks;

import tasks.taskpackages.task66.Matrix;

import java.io.FileNotFoundException;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task66 implements TasksMainMethod{
    @Override
    public void run() {
        try {

            List input = readMatrix();

            Matrix initial = Matrix.squareMatrix(input);

            System.out.print("Input degree of matrix: ");
            Scanner sc = new Scanner(System.in);
            int degree = sc.nextInt();

            if(degree < 0) throw new InputMismatchException("ERROR: Invalid degree");

            Matrix res = null;
            if(degree == 0){
                res = Matrix.identityMatrix(initial.sizeN());
            }else{
                res = new Matrix(initial);
                while(degree > 1){
                    degree--;
                    res = res.multiply(initial);
                }
            }

            System.out.println(res);

        }  catch (FileNotFoundException fnfex) {
            System.err.println("ERROR: File not found");
        } catch (NumberFormatException nfex){
            System.err.println("ERROR: incorrect number format in input file");
        } catch(InputMismatchException imex){
            System.err.println(imex.getMessage());
        } catch (Exception ex){
            System.err.println("Program is failed!");
        }
    }

    private List<Float> readMatrix() throws FileNotFoundException{
        Scanner reader = new Scanner(new File("d:\\Danik_Prog\\BSUUniversity\\PROGRAMMING_TERM2\\Java\\181024_lab7\\input.txt"));
        List<Float> inputList = new ArrayList<>();

        String text = null;
        while(reader.hasNext()){
            inputList.add(reader.nextFloat());
        }
        reader.close();

        int size = (int)Math.sqrt(inputList.size());
        if(size*size < inputList.size()){
            throw new InputMismatchException("ERROR: Invalid number of matrix elements");
        }
        return inputList;
    }
}
