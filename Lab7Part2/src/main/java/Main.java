import com.utility.ClassUtility;

/**
 * @author Anthony Vallin, aav5195
 * date: 20220224
 * class: SWENG431
 * assignment: Lab7 part2
 * description: Displays skeleton of a .class file
 */

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class c = Class.forName("com.lab7.Rectangle");
        ClassUtility.printClassSkeleton(c);
    }
}
