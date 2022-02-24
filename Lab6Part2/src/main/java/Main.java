/**
 * @author Anthony Vallin, aav
 * date: 20220217
 * class: SWENG431
 * assignment: Lab6Part2
 */

public class Main
{
    public static void main(String[] args)
    {
        MyJUnit myJUnit = new MyJUnit();

        for (String arg : args)
        {
            if (!arg.equals(""))
            {
                myJUnit.runTestlet(arg);
            }
        }
    }
}
