import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Arc extends Function {
	
	protected double r;
	protected double xcenter;
	protected double ycenter;
	
	public Arc (double r, double xcenter, double ycenter) {
		super(0, 0);
		this.r = r;
		this.xcenter = xcenter;
		this.ycenter = ycenter;
	}

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

		for (double x = super.x1; x < super.x2; x = Math.round((x + deltaX) * 10)/10.0) {
			
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

		// Temporary variables representing the coordinates of the line segments of the
		// function
		double startX = 0;
		double startY = 0;
		double endX = 0;
		double endY = 0;

		double currentX = super.x1; // The current x value
		double oldX = 0; // The previous x value

		/*
		 * Calculates all of the coordinates of the function and draws line segments
		 * between each of them
		 */
		while (currentX < super.x2) {
			
			oldX = currentX; // updates the previous x value

			currentX = Math.round((currentX + deltaX) * 10)/10.0; // moves to next x value

			// If the start or end y values are undefined, don't include them in the
			// function
			if (undefined(oldX) || undefined(currentX) == true)
				continue;

			// Draws the line segment of the function

			startX = (oldX - centerDomain) * scaleX + centerX;
			startY = centerY - (val(oldX) - centerRange) * scaleY;
			endX = (currentX - centerDomain) * scaleX + centerX;
			endY = centerY - (val(currentX) - centerRange) * scaleY;
			
			gc.setStroke(getColour());
			gc.strokeLine(startX, startY, endX, endY);

		}


	}

	@Override
	public double val(double x) {
		
		double y = Math.sqrt(r*r - Math.pow(x - xcenter, 2)) + ycenter;
		
		return y;
	}

	@Override
	public boolean undefined(double x) {
		
		double y = val(x);
		
		if (Double.isNaN(y) == true)
			return true;
		else 
			return false;
	}

	@Override
	public double getArea(double x_start, double x_end) {
		
		double currentX = x_start;
		double area = 0;
		
			while (currentX < x_end)
			{
				if (undefined(currentX) == false)
				{
					area += val(currentX) * deltaX;
				}
				
				currentX = Math.round((currentX + deltaX) * 10)/10.0; // moves to next x value
			}
	
		
		return area;
	}

	@Override
	public double getSlope(double x) {
		
		double slope = (val(x + deltaX) - val(x - deltaX))/(2*deltaX);
		
		return slope;
	}

	@Override
	public String toString() {
		
		String s = "";
		
		s += "sqrt(";
		
		if (r == 0)
			s += "-";
		else
			s += "(" + r + ")^2-";
		
		if (xcenter == 0)
			s += "(x)^2)";
		else if (xcenter > 0)
			s += "(x-" + xcenter + ")^2)";
		else 
			s += "(x+" + -xcenter + ")^2)";
		
		if (ycenter == 0)
			return s;
		else if (ycenter > 0)
			s += "+" + ycenter;
		else
			s += "-" + -ycenter;
		
		return s;
		
	}

}
