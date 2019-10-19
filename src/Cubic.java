// Arsen Cui
// ICS4U1-01
// October 20, 2019
// Mr. Radulovic
// ICS4U1 Functions Inheritance Assignment

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Cubic extends Function {

	/* Variables representing the corresponding variables in the equation
	 * of the cubic, quadratic, linear, and parabola functions */
	protected double a, b, c, d, x1; 
	

	public Cubic(double a, double b, double c, double d, double x1) {
		
		super(0, 0); // Sets a random initial value for the domain. Will soon be overwritten

		// Initializes the variable values based on the values set by the object
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.x1 = x1;

	}

	// Method used to draw the function on the screen
	@Override
	public void draw(Canvas c) {

		GraphicsContext gc = c.getGraphicsContext2D();

		// Variables representing the center coordinates of the canvas
		double centerX = c.getWidth() / 2;
		double centerY = c.getHeight() / 2;

		// Gets domain of the function
		super.x1 = getStartDomain();
		super.x2 = getEndDomain();

		// Ratios to scale the x and y values by
		double scaleX = 1;
		double scaleY = 1;

		double domainSize = Math.abs(super.x2 - super.x1); // Size of the domain
		scaleX = c.getWidth() / domainSize;
		double centerDomain = (super.x1 + super.x2) / 2; // Represents center coordinate of domain

		double largestY = -Double.MAX_VALUE; // Variable used to track the largest value of y
		double smallestY = Double.MAX_VALUE; // Variable used to track the smallest value of y

		/* Finds the largest and smallest y values by going
		 * through every single point on the function */
		for (double x = super.x1; x < super.x2; x = Math.round((x + deltaX) * 10) / 10.0) {

			// If the function is not defined at this point, skip over it
			if (undefined(x) == true)
				continue;

			if (val(x) > largestY)
				largestY = val(x);

			if (val(x) < smallestY)
				smallestY = val(x);
		}

		double rangeSize = Math.abs(largestY - smallestY); // Size of the range
		scaleY = c.getHeight() / rangeSize;
		double centerRange = (largestY + smallestY) / 2; // Represents center coordinate of range

		/* Temporary variables representing the coordinates
		 * of the line segments of thefunction */
		double startX = 0;
		double startY = 0;
		double endX = 0;
		double endY = 0;

		double currentX = super.x1; // The current x value
		double oldX = 0; // The previous x value

		/* Calculates all of the coordinates of the function and draws line segments
		 * between each of them */
		while (currentX < super.x2) {

			oldX = currentX; // updates the previous x value

			currentX = Math.round((currentX + deltaX) * 10) / 10.0; // moves to next x value

			/* If the start or end y values are undefined,
			 * don't include them in the function */
			if (undefined(oldX) || undefined(currentX) == true)
				continue;

			/* Draws the line segment of the function with scaling
			 * and shifting to fit function on the screen */
			
			startX = (oldX - centerDomain) * scaleX + centerX;
			startY = centerY - (val(oldX) - centerRange) * scaleY;
			endX = (currentX - centerDomain) * scaleX + centerX;
			endY = centerY - (val(currentX) - centerRange) * scaleY;

			gc.setStroke(getColour());
			gc.strokeLine(startX, startY, endX, endY);

		}

	}
	
	// Method used to return the value of y at a specific value of x
	@Override
	public double val(double x) {

		double y = a * Math.pow(x - x1, 3) + b * Math.pow(x - x1, 2) + c * (x - x1) + d;

		return y;

	}

	// Method used to determine whether the function is defined at a specific value of x
	@Override
	public boolean undefined(double x) {

		double y = val(x);

		if (Double.isNaN(y) == true)
			return true;
		else
			return false;
	}

	// Method used to return the area underneath the function
	@Override
	public double getArea(double x_start, double x_end) {

		double currentX = x_start;
		double area = 0;

		while (currentX < x_end) {
			area += val(currentX) * deltaX;

			currentX = Math.round((currentX + deltaX) * 10) / 10.0; // moves to next x value
		}

		return area;
	}

	// Method used to return the slope of the function at a given point
	@Override
	public double getSlope(double x) {

		double slope = (val(x + deltaX) - val(x - deltaX)) / (2 * deltaX);

		return slope;
	}

	// Method used to return the equation of the function as a string
	@Override
	public String toString() {

		String s = "";

		// Handles a
		
		if (a == 1.0)
			s += "(x";
		else if (a == -1.0)
			s += "-(x";
		else if (a != 0)
			s += a + "*(x";

		// Handles x1
		
		if (a != 0) {
			if (x1 > 0)
				s += "-" + x1 + ")^3";
			else if (x1 == 0)
				s += ")^3";
			else if (x1 < 0)
				s += "+" + -x1 + ")^3";

			if (b > 0 || c > 0 || d > 0)
				s += "+";
		}

		// Handles b
		
		if (b == 1.0)
			s += "(x";
		else if (b == -1.0)
			s += "-(x";
		else if (b != 0)
			s += b + "*(x";

		// Handles x1
		
		if (b != 0) {
			if (x1 > 0)
				s += "-" + x1 + ")^2";
			else if (x1 == 0)
				s += ")^2";
			else if (x1 < 0)
				s += "+" + -x1 + ")^2";

			if (c > 0 || d > 0)
				s += "+";
		}

		// Handles c
		
		if (c == 1.0)
			s += "(x";
		else if (c == -1.0)
			s += "-(x";
		else if (c > 0 || c < 0)
			s += c + "*(x";

		// Handles x1
		
		if (c != 0) {
			if (x1 > 0)
				s += "-" + x1 + ")";
			else if (x1 == 0)
				s += ")";
			else if (x1 < 0)
				s += "+" + -x1 + ")";

			if (d > 0)
				s += "+";
		}

		// Handles d
		
		if (d != 0)
			s += d;

		if (a == 0 && b == 0 && c == 0 && d == 0)
			s += d;

		return s;

	}

}
