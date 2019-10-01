/* File: GraphicalPiApproximation.java
 * ------------------------------
 * This program approximates to Pi and visualizes this process.
 * 
 * Requirements:
 *  - A good approximation to Pi. Pi is approximately 3,14159265.
 *  In this example it is sufficient to achieve 3.14 � 0.02 approximation.
 * 
 * Recall our PiApproximation example. It is crucial to understand that the 
 * central point of our circle is not at (0, 0) as is in PiApproximation example. 
 * You will adapt the same idea here but considering the difference in central 
 * points.
 * 
 * Note that approximation is necessary but not sufficient to get
 * full grade. You are responsible to visualize it like in the documents.
 * 
 * Some information:
 * 
 * - You need to create NPOINTS points. At the beginning, NPOINTS =
 * 1000. This does not provide you a good approximation but in the
 * implementation phase, it gives you some intuition. When you
 * successfully implement this, please try a larger value of NPOINTS to
 * see if the approximation would be better.
 * 
 * - Note that in an x�y Cartesian coordinate system, the circle with
 * centre coordinates (a, b) and radius r, if the point is in the
 * circle, following inequality should be correct: 
 * (x - a)^2 + (y - b)^2 < r^2
 * 
 * Location Information:
 * 	Square: should be 200x200 and starts at (0,0)
 * 	Circle: Central point of the circle is at (100, 100) and its radius is 100.
 *  Points: should fall within square randomly.
 *  You might like to use private constants created at the bottom of this file.
 * 
 * Tips: 
 *  Be careful with division, Java returns 0 for 3/5, for instance.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class GraphicalPiApproximation extends GraphicsProgram {
	GOval point = null;
	
	public void run() {

		resize(900, 900);

		GOval circle = createCircle(CIRCLE_X, CIRCLE_Y, CIRCLE_RADIUS);
		add(circle);
		GRect r = new GRect(0, 0, RWIDTH, RHEIGHT);
		add(r);

		
		int inside = 0;

		/*
		 * Here, you need to create random points inside the square, draw them 
		 * on the screen using createPoint method and count how many points fall in the circle. We
		 * provided you a variable above named `inside`, for the counting
		 * process.
		 * 
		 * Note that in order to achieve the correct approximation, all points 
		 * should fall within the square and the points within the circle should 
		 * increment the 'inside' variable.
		 */
		// Your code starts here
		
		int centerX = CIRCLE_X;
		int centerY = CIRCLE_X;
		for(int i=0; i<NPOINTS;i++) {
			double a = rgen.nextDouble(0,RWIDTH);
			double b = rgen.nextDouble(0,RWIDTH);
			createPoint(a,b);
			int distX = centerX - (int)point.getX();
			int distY = centerY - (int)point.getY();
			if(distX<0) distX = -distX;
			if(distY<0) distY = -distY;
			if((distX*distX) + (distY*distY) <= (CIRCLE_X*CIRCLE_X)) {
				inside++;
				point.setFillColor(Color.GREEN);
			}
		}
		println(inside);
		double approximatePI = ((double)inside/NPOINTS) * 4;
		// Your code ends here
		System.out.println("PI is approximately " + approximatePI);
		GLabel text=new GLabel(""+approximatePI,50,50);
		text.setColor(Color.WHITE);
		text.setFont(textFontStyle);
		add(text);
	}
	/*
	 * You need to implement createPoint().
	 * 
	 * Constraints: - Central point should be at (x,y) - Its radius should be
	 * POINT_RADIUS - Point should be black and filled.
	 * 
	 * TIPS: createCircle method creates circles.
	 */

	private GOval createPoint(double a, double b) {	
		// Your code starts here
		point = new GOval(a,b,POINT_RADIUS,POINT_RADIUS);
		point.setFilled(true);
		point.setFillColor(Color.RED);
		add(point);
		// Your code ends here
		return point;
	}

	/*
	 * Remember the HW3b DrawStoplight example. This method creates a circular
	 * GOval object centered at (x, y) with radius r. The GOval is set to be
	 * filled and colored in the specified color.
	 */
	private GOval createCircle(double x, double y, double r) {
		GOval circle;
		circle = new GOval(x - r, y - r, 2 * r, 2 * r);
		//circle.setColor(Color.WHITE);
		//circle.setFilled(true);
		return circle;
	}

	/* Private constants */
	static final int NPOINTS = 10000000;
	static final double POINT_RADIUS = 1.5;
	static final int RWIDTH = 900;
	static final int RHEIGHT = 450;
	static final int CIRCLE_X = 450;
	static final int CIRCLE_Y = 450;
	static final double CIRCLE_RADIUS = 450;
	private static final String textFontStyle="arial-BOLD-24";
	/* Instance variable */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
