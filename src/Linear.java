import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Linear extends Function implements Calculations, Drawable{
	
	protected double a; // a represents m in linear function
	protected double b;
	protected double x1;

	public Linear(double a, double b, double x1) {
		super(0, 0);
		
		this.a = a;
		this.b = b;
		this.x1 = x1;	
	}
	
	@Override
	public void draw(Canvas c) {
/*		super.x1 = f.x1;
		super.x2 = f.x2;
		
		double y1 = a * (super.x1 - this.x1) + b;
		double y2 = a * (super.x2 - this.x1) + b;
		
		gc.strokeLine(f.center + super.x1, f.center - y1, f.center + x2, f.center - y2);*/
		
	}
	
	@Override
	public double val(double x) {
		
		double y = a * (x - x1) + b;
		
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
		
		double deltaX = 0.1;
		double currentX = x_start;
		double area = 0;
		
		while (currentX <= x_end)
		{
			area += val(currentX) * deltaX;
			
			currentX = (Math.round((currentX + deltaX) * 10))/10.0;
		}
		
		return area;
		
	}

	@Override
	public double getSlope(double x) {
		return a;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		
		if (a == 1.0)
			s += "(x";
		else if (a == -1.0)
			s += "-(x";
		else if (a == 0)
		{
			s += b;
			return s;
		}
		else 
			s += a + "*(x";
		
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
	        else if (b == 0)
	        	return s;
		}
		
		return s;
		
	}
	
}
