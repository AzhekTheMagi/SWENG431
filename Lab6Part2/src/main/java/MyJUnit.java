public class MyJUnit extends TestHarness
{
    public void runTestlet(String testlet)
    {
        try
        {
            Class c  = Class.forName(testlet);
            Object o = c.newInstance();
            TestletIF testletIF = (TestletIF) o;
            testletIF.runTest(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
