/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author wxw18
 */
@RunWith(Parameterized.class)
public class JUnitIT
{
    static int idx = 0;
    @Parameters
    public static Collection<Object[]> data() {
        //testcases provided inlab
        return Arrays.asList(new Object[][]{
            {9, 21, 30, -12},
            {5, 6, 11, -1},
            {4, 14, 18, -10},
            {3, 12, 15, -9},
            {8, 19, 27, -11},
            {6, 14, 20, -8},});
    }

    int a, b, expSum, expSubtract;

    public JUnitIT(int a, int b, int expSum, int expSubtract) {
        this.a = a;
        this.b = b;
        this.expSum = expSum;
        this.expSubtract = expSubtract;
    }

    public static String foo(int a, int b, int c)
    {
        if (a == b && b ==c)
            return "equilateral";
        else if (a == b || a == c || b == c)
            return "isosceles";
        else
            return "scalene";
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println(++idx+", "+a + ", " + b);
    }

    @After
    public void tearDown() {
    }
/*
    /**
     * Test of main method, of class JUnit.
     */
/*    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JUnit.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sum method, of class JUnit.
     */
/*    @Test
    public void testSum() {
        System.out.println("sum");
        int a = 0;
        int b = 0;
        JUnit instance = new JUnit();
        int result = instance.sum(a, b);
        assertEquals(expSum, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of subtract method, of class JUnit.
     */
/*    @Test
    public void testSubtract() {
        System.out.println("subtract");
        int a = 0;
        int b = 0;
        JUnit instance = new JUnit();
        int result = instance.subtract(a, b);
        assertEquals(expSubtract, result);
        // TODO review the generated test code and remove the default call to fail.
    }
*/
}
