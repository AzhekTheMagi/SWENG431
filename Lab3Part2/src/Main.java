/**
 * @author Anthony Vallin, aav5195
 * Class: SWENG431
 * Date: 20220129
 * Assignment: Lab3, part2
 * Description: Applies Newton-Raphson's method that returns a solution that is either minimum or maximum value for z.
 */

public class Main
{
    public static void main(String[] args)
    {
        double x = Math.random() * 12 - 6; // x-range: -6 <= x <= 6
        double y = Math.random() * 10 - 5; // y-range: -5 <= y <= 5
        double tmpX = 0;
        double tmpY = 0;
        boolean xFlag = false;
        boolean yFlag = false;

        for (int i = 0; i < 10000; i++)
        {
            tmpX = getXRoot(x, y);

            if (Math.abs(x - tmpX) < .00001)
            {
                xFlag = true;
                break;
            }

            x = tmpX;
        }

        for (int i = 0; i < 10000; i++)
        {
            tmpY = getYRoot(x, y);

            if (Math.abs(y - tmpY) < .00001)
            {
                yFlag = true;
                break;
            }

            y = tmpY;
        }

        if (xFlag && yFlag)
        {
            double z = 0;

            z = Math.pow(x, 4) + (2 * Math.pow(y, 6)) - (x * y) - x + 2;
            System.out.println("z = " + z);
        }
        else
        {
            System.out.println("z = infinity");
        }
    }

    public static double getXRoot(double x, double y)
    {
        // Equation: z = x^4 + 2y^6 - xy -x +2
        double zX = (4 * Math.pow(x, 3)) - y - 1; // f'(x)  = 4x^3 -y -1
        double zXX = 12 * Math.pow(x, 2);         // f''(x) = 12x^2

        return (x - (zX / zXX));
    }

    public static double getYRoot(double x, double y)
    {
        // Equation: z = x^4 + 2y^6 - xy -x +2
        double zY  = 12 * Math.pow(y, 5) - x;
        double zYY = 60 * Math.pow(y, 4);

        return (y - (zY / zYY));
    }
}
