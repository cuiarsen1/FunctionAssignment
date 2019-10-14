import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Cubic extends Function implements Calculations, Drawable {
	
	protected double a, b, c, d, x1;

	public Cubic(double a, double b, double c, double d, double x1) {
		super(0, 0);
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.x1 = x1;
		
	}

	DO DRAW METHOD
	@Override
	public void draw(Canvas c) {
		
		GraphicsContext gc = c.getGraphicsContext2D();
		super.x1 = super.getStartDomain();
		super.x2 = super.getEndDomain();
		ArrayList<double[]> coordinates = new ArrayList<double[]>();
		
		double currentX = super.x1;
		
		while (currentX < super.x2)
		{
			if (undefined(currentX) == false)
			{
				double y = val(currentX);
				
				double[] point = {currentX, y};
				coordinates.add(point);
			}
			
			currentX += deltaX;
		}
		
		//gc.strokeLine(center + super.x1, center - y1, center + x2, center - y2);
	}

	@Override
	public double val(double x) {
		
		double y = a*Math.pow(x - x1, 3) + b*Math.pow(x - x1, 2) + c*(x - x1) + d;
		
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
			area += val(currentX) * deltaX;
			
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
			s += "(x";
		else if (a == -1.0)
			s += "-(x";
		else if (a != 0)
			s += a + "*(x";
		
		if (a != 0)
		{
			if (x1 > 0)
				s += "-" + x1 + ")^3";
			else if (x1 == 0)
				s += ")^3";
			else if (x1 < 0)
				s += "+" + -x1 + ")^3";
			
			if (b > 0 || c > 0 || d > 0)
				s += "+";
		}
		
		if (b == 1.0)
			s += "(x";
		else if (b == -1.0)
			s += "-(x";
		else if (b != 0)
			s += b + "*(x";
		
		if (b != 0)
		{
			if (x1 > 0)
				s += "-" + x1 + ")^2";
			else if (x1 == 0) 
				s += ")^2";
			else if (x1 < 0)
				s += "+" + -x1 + ")^2";
			
			if (c > 0 || d > 0)
				s += "+";
		}
		
		if (c == 1.0)
			s += "(x";
		else if (c == -1.0)
			s += "-(x";
		else if (c > 0 || c < 0)
			s += c + "*(x";
		
		if (c != 0)
		{
			if (x1 > 0)
				s += "-" + x1 + ")";
			else if (x1 == 0) 
				s += ")";
			else if (x1 < 0)
				s += "+" + -x1 + ")";
			
			if (d > 0)
				s += "+";
		}
		
		if (d != 0)
			s += d;
		
		if (a == 0 && b == 0 && c == 0 && d == 0)
			s += d;
		
		return s;
		
	}

}
