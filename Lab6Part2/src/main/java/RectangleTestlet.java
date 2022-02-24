public class RectangleTestlet implements TestletIF
{
    // Normal Boundary analysis, range 1<=x<=10. Array contains {height, length, expected result}
    int[][] rectTestCases = {{5,5,25}, {5,1,5}, {5,2,10}, {5,9,45}, {5,10,50}, {1,5,5}, {2,5,10}, {9,5,45}, {10,5,50}};

    @Override
    public void runTest(TestHarness testHarness)
    {
        int pass = 0;
        int fail = 0;

        for (int[] recTests : rectTestCases)
        {
            int area = Rectangle.getArea(recTests[0], recTests[1]);
            if (testHarness.checkEqual(area, recTests[2]))
                pass++;
            else
                fail++;

            System.out.println("Rectangle getArea(" + recTests[0] + ',' + recTests[1] + ") | expected: " + recTests[2] +
                               ", result: " + area);
        }

        System.out.println("Rectangle passing tests: " + pass + ", failed tests: " + fail);
    }
}
