package edu.nmsu.cs.circles;

/***
 * Example JUnit testing class for Circle1 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle1Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;

public class Circle1Test
{
	// Data you need for each test case
	private Circle1 circle1;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		circle1 = new Circle1(1, 2, 3);
	}

	//
	// Stuff you want to do after each test case
	//
	@After
	public void teardown()
	{
		System.out.println("\nTest finished.");
	}

	//
	// Test a simple positive move
	//
	@Test
	public void simpleMove()
	{
		Point p;
		System.out.println("Running test simpleMove.");
		p = circle1.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
	}

	//
	// Test a simple negative move
	//
	@Test
	public void simpleMoveNeg()
	{
		Point p;
		System.out.println("Running test simpleMoveNeg.");
		p = circle1.moveBy(-1, -1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
	}

	//
	//Test a negative x movement and a positive y movement
	//
	@Test
	public void simpleMoveNegAndPos()
	{
		Point p;
		System.out.println("Running test simpleMoveNegAndPos.");
		p = circle1.moveBy(-1, 1);
		Assert.assertTrue(p.x == 0 && p.y == 3);
	}

	//
	//Test a positive x movement and a negative y movement
	//
	@Test
	public void simpleMovePosAndNeg()
	{
		Point p;
		System.out.println("Running test simpleMovePosAndNeg.");
		p = circle1.moveBy(1, -1);
		Assert.assertTrue(p.x == 2 && p.y == 1);
	}

	//
	//Test a x movement with no y movement
	//
	@Test
	public void simpleMoveX()
	{
		Point p;
		System.out.println("Running test simpleMoveX.");
		p = circle1.moveBy(1, 0);
		Assert.assertTrue(p.x == 2 && p.y == 2);
	}

	//
	//Test a y movement with no x movement
	//
	@Test
	public void simpleMoveY()
	{
		Point p;
		System.out.println("Running test simpleMoveY.");
		p = circle1.moveBy(0, 1);
		Assert.assertTrue(p.x == 1 && p.y == 3);
	}
    
    //
    //Test scale with a factor less than 1
    //
    @Test
    public void scaleLess()
    {
        System.out.println("Running test scaleLess.");
        double r = circle1.scale(.5);
        Assert.assertTrue(r == 1.5);
    }
    
    //
    //Test scale with a factor greater than 1
    //
    @Test
    public void scaleMore()
    {
        System.out.println("Running test scaleMore.");
        double r = circle1.scale(2.0);
        Assert.assertTrue(r == 6);
    }

	//
    //Test scale with a factor equal to 1
    //
    @Test
    public void scaleEqual()
    {
        System.out.println("Running test scaleEqual.");
        double r = circle1.scale(1.0);
        Assert.assertTrue(r == 3);
    }
    
    //
	//Test intersection with separtate circles
	//
	@Test
	public void intersectZeroSeparate()
	{
        Circle1 circle2 = new Circle1(10, 2, 3);
		System.out.println("Running test intersectZeroSeparate.");
		boolean intersects = circle1.intersects(circle2);
		Assert.assertTrue(!intersects);
	}
    
    //
	//Test intersection with circles inside of eachother
	//
	@Test
	public void intersectZeroInside()
	{
        Circle1 circle2 = new Circle1(1, 2, 1);
		System.out.println("Running test intersectZeroInside.");
		boolean intersects = circle1.intersects(circle2);
		Assert.assertTrue(!intersects);
	}
    
    //
	//Test intersection with 1 intersection point
	//
	@Test
	public void intersectOnePoint()
	{
        Circle1 circle2 = new Circle1(7, 2, 3);
		System.out.println("Running test intersectOnePoint.");
		boolean intersects = circle1.intersects(circle2);
		Assert.assertTrue(intersects);
	}
    
    //
	//Test intersection with 2 intersection points
	//
	@Test
	public void intersectTwoPoints()
	{
        Circle1 circle2 = new Circle1(2, 2, 3);
		System.out.println("Running test intersectTwoPoints.");
		boolean intersects = circle1.intersects(circle2);
		Assert.assertTrue(intersects);
	}
    
    //
	//Test intersection with infinite intersection points
	//
	@Test
	public void intersectInfinitePoints()
	{
        Circle1 circle2 = new Circle1(1, 2, 3);
		System.out.println("Running test intersectInfinitePoints.");
		boolean intersects = circle1.intersects(circle2);
		Assert.assertTrue(intersects);
	}
    
	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle1Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}
