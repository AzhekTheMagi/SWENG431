public class BoxTestlet implements TestletIF
{
    // Normal Boundary analysis, range 1<=x<=10. Array contains {height, width, length, expected result}
    double [][] boxTestCases ={{5,5,5,125}, {5,5,1,25}, {5,5,2,50}, {5,5,9,225}, {5,5,10,250}, {5,1,5,25}, {5,2,5,50},
                               {5,9,5,225}, {5,10,5,250}, {1,5,5,25}, {2,5,5,50}, {9,5,5,225}, {10,5,5,250}};

    @Override
    public void runTest(TestHarness testHarness)
    {
        int pass = 0;
        int fail = 0;

        for (double[] boxTests : boxTestCases)
        {
            double volume = Box.getVolume(boxTests[0], boxTests[1], boxTests[2]);
            if (testHarness.checkEqual(volume, boxTests[3]))
                pass++;
            else
                fail++;

            System.out.println("Box getVolume(" + boxTests[0] + ',' + boxTests[1] + ", " + boxTests[2] +
                               ") | expected: " + boxTests[3] + ", result: " + volume);
        }

        System.out.println("Box passing tests: " + pass + ", failed tests: " + fail);
    }
}
