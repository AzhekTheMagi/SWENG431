/**
 * author: Anthony Vallin, aav5195
 * date: 20220211
 * assignment: Lab5
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static javafx.scene.input.KeyCode.T;

public class Main
{
    static ArrayList<Variables> variableList;
    static PrintWriter printWriter;

    public static void main(String[] args)
    {
        File inputTestFile  = new File("src\\main\\resources\\Eq.txt");
        File outputTestFile = new File("test.txt");

        variableList = new ArrayList<>();
        openVariableTestFile(inputTestFile);

        try
        {
            printWriter = new PrintWriter(new FileWriter(outputTestFile));
            strongNormalTest(variableList);
            printWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Opens a test file filled with variables and their equivalence classes.
    // Saves variables in ArrayList for later testing
    private static void openVariableTestFile(File file)
    {
        try
        {
            Scanner scan = new Scanner(file);

            do
            {
                variableList.add(new Variables(scan.nextLine()));

            } while (scan.hasNext());

            scan.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static void strongNormalTest(ArrayList<Variables> varList, int... args)
    {
        // base case
        if (varList.size() == 0)
        {
            // formats and sets output for output test file
            StringBuilder strBuilder = new StringBuilder("test <");

            for (int i = 0; i < args.length; i++)
            {
                strBuilder.append(args[i]);
                strBuilder.append(",");
            }

            strBuilder.deleteCharAt(strBuilder.length() - 1);
            strBuilder.append("> | ");

            // calculates expected result of tests
            int expectedResult = 0;
            for (int i = 0; i < args.length; i++)
            {
                expectedResult += variableList.get(i).check(args[i]);
            }

            strBuilder.append("Expected: " + expectedResult + " | " + "Result: " + foo(args) + '\n');
            printWriter.write(strBuilder.toString());

            return;
        }

        // beginning of recursive case
        Variables currentVariable = varList.get(0);
        ArrayList<Integer> tmpList = new ArrayList<>();

        for (int i = 0; i < args.length; i++)
        {
            tmpList.add(args[i]);
        }

        for (int j = 0; j < currentVariable.eqClassList.size(); j++)
        {
            ArrayList<Integer> newTestList = new ArrayList<>(tmpList);
            newTestList.add(getRandomRangeBounds(currentVariable.eqClassList.get(j).lowerBound, currentVariable.eqClassList.get(j).upperBound));

            int[] arr = newTestList.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
            strongNormalTest(new ArrayList<>(varList.subList(1, varList.size())), arr);
        }
    }

    // Takes k integers as input arguments, i.e., foo(int n, int n2, ..., int nk) and computes the sum
    // of the returned values by the check function for all inputs per lab 5 instructions.
    private static int foo(int... args)
    {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum += variableList.get(i).check(args[i]);
        }

        return sum;
    }

    // Gets random integer between the lower and upper bounds (inclusive) of equivalence class
    private static int getRandomRangeBounds(int lowerBound, int upperBound)
    {
        return (ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1));
    }
}
