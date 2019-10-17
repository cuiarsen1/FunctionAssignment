import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Logarithm extends Function {
	
	protected double a, b, x1;
	
	public Logarithm(double a, double b, double x1) {
		super(0, 0);
		
		this.a = a;
		this.b = b;
		this.x1 = x1;
		
	}

	@Override
	public void draw(Canvas c) {
		
		GraphicsContext gc = c.getGraphicsContext2D();
		
		// Variables representing the center coordinates of the canvas
		double centerX = c.getWidth()/2;
		double centerY = c.getHeight()/2;
		
		// Gets domain of the function
		super.x1 = getStartDomain();
		super.x2 = getEndDomain();
		
		
		double scaleX = 1;
		double scaleY = 1;
		
		if (Math.abs(super.x2) > c.getWidth()/2 || Math.abs(super.x1) > c.getWidth()/2)
		{
			if (Math.abs(super.x1) >= Math.abs(super.x2))
			{
				scaleX = (c.getWidth()/2)/Math.abs(super.x1);
			}
			else if (Math.abs(super.x2) >= Math.abs(super.x1))
			{
				scaleX = (c.getWidth()/2)/Math.abs(super.x2);
			}
		}
		
		double largestY = 0; // Variable used to track the largest absolute value of y
		
		// To scale y, find the largest absolute value of y, and see if it exceeds screen parameters. Then, do the same thing as scaleX
		for (double x = super.x1; x < super.x2; x += deltaX)
		{
			if (Math.abs(val(x)) > c.getHeight()/2)
				largestY = Math.abs(val(x));
		}
		if (largestY > c.getHeight()/2)
			scaleY = (c.getHeight()/2)/largestY;
		
		
		// Temporary variables representing the coordinates of the line segments of the function
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
		while (currentX < super.x2) 
		{
			oldX = currentX; // updates the previous x value

			currentX += deltaX; // moves to next x value
			
			// If the start or end y values are undefined, don't include them in the function
			if (undefined(oldX) || undefined(currentX) == true)
				continue;

			// Draws the line segment of the function
			
			startX = oldX * scaleX + centerX;
			startY = centerY - val(oldX) * scaleY;
			endX = currentX * scaleX + centerX;
			endY = centerY - val(currentX) * scaleY;

			gc.setStroke(getColour());
			gc.strokeLine(startX, startY, endX, endY);
			
		}
		
	}

	@Override
	public double val(double x) {
		
		double y = a*Math.log(x - x1) + b;
		
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
				
				currentX += deltaX;
			}
	
		
		return area;
	}

	@Override
	public double getSlope(double x) {
		
		double deltaX = 0.001;
		double slope = (val(x + deltaX) - val(x - deltaX))/(2*deltaX);
		
		return slope;
	}

	@Override
	public String toString() {
		
		String s = "";
		
		if (a == 1.0)
			s += "ln(x";
		else if (a == -1.0)
			s += "-ln(x";
		else if (a == 0)
		{
			s += b;
			return s;
		}
		else 
			s += a + "*ln(x";
		
		if (x1 > 0)
			s += "-" + x1 + ")";
		else if (x1 == 0) 
			s += ")";
		else if (x1 < 0)
			s += "+" + -x1 + ")";
		
		if (a != 0)
		{
			if (b > 0)
	        	s += "+" + b;
	    	else if (b < 0)
	        	s += "-" + -b;
		}
		
		return s;
		
		
	}

}
