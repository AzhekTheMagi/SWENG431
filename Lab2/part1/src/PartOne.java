
/**
 *
 * @author Anthony Vallin, aav5195
 * Class: SWENG431
 * Date: 20220120
 * Assignment: Lab 2, part1
 * Description: Finds the root of a given polynomial function. Function provided by the lab.
 */

public class PartOne
{
    int[] coefficients = new int[] {9,8,6,8,6,6,7}; // First 7 numbers of PSU ID. For testing purposes only.
    static int COEFFICIENT_COUNT = 6; // Number of coefficients in lab
    int MAX_ITERATION = 2000; // Max number of iterations for testing

    public static void main(String[] args)
    {
        PartOne partOne = new PartOne();
        int counter = 0;
        double x0;
        double x;

        x0 = Math.random() * 2000 - 1000; // Random initial starting value

        System.out.println("Initial guess, i.e. x0: " + x0);

        x = partOne.findRoot(x0);

        if (x == -1)
        {
            System.out.println("Root not found!");
        }
        else
        {
            System.out.println("Root is: " + x);
            System.out.println("Polynomial value = " + partOne.f(x));
        }
    }

    public double findRoot(double x)
    {
        int iterationsCounter = 0;
        double x0 = x;
        double x1 = x0;

        x0 = getNextRoot(x);

        for (int i = 0; i < MAX_ITERATION; i++)
        {
            if (Math.abs(x1 - x0) < 0.000001)
            {
                System.out.println("Iterations: " + iterationsCounter);
                return x0;
            }

            x1 = x0;
            x0 = getNextRoot(x0);

            iterationsCounter++;
        }

        return -1;
    }

    public double getNextRoot(double x)
    {
        double f = f(x);
        double _f = _f(x);

        return (x - (f / _f));
    }

    public double f(double x)
    {
        return ((coefficients[0] * Math.pow(x, 6)) - (coefficients[1] * Math.pow(x, 5)) +
                (coefficients[2] * Math.pow(x, 4)) - (coefficients[3] * Math.pow(x, 3)) +
                (coefficients[4] * Math.pow(x, 2)) - (coefficients[5] * x + coefficients[6]));
    }

    public double _f(double x)
    {
        return ((6 * coefficients[0] * Math.pow(x, 5)) - (5 * coefficients[1] * Math.pow(x, 4)) +
                (4 * coefficients[2] * Math.pow(x, 3)) - 3 * (coefficients[3] * Math.pow(x, 2)) +
                (2 * coefficients[4] * x) - coefficients[5]);
    }
}
