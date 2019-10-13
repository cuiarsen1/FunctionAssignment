import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Quadratic extends Linear implements Calculations, Drawable {
	
	protected double a;

	public Quadratic(double a, double b, double c, double x1) {
		super(b, c, x1);
		
		this.a = a;
		
	}
	
	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double val(double x) {
		
		double y = a*Math.pow(x - x1, 2) + super.val(x);
		
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

		double deltaX = 0.001;
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
				s += "-" + x1 + ")^2";
			else if (x1 == 0) 
				s += ")^2";
			else if (x1 < 0)
				s += "+" + -x1 + ")^2";
			
			if (super.a > 0)
				s += "+";
			else if (super.a == 0)
			{
				if (super.b > 0)
					s += "+";
				else if (super.b == 0)
					return s;
			}	
		}
		
		s += super.toString();
		
		return s;
		
	}

}
