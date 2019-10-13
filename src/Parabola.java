import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Parabola extends Quadratic implements Calculations, Drawable {
	
	public Parabola(double a, double b, double x1) {
		
		super(a, 0, b, x1);

	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double val(double x) {
		
		double y = super.val(x);
		
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
		else if (a == 0)
		{
			s += b;
			return s;
		}
		
		if (a != 0)
		{
			if (x1 > 0)
				s += "-" + x1 + ")^2";
			else if (x1 == 0) 
				s += ")^2";
			else if (x1 < 0)
				s += "+" + -x1 + ")^2";
		}
		
		if (b > 0)
			s += "+" + b;
		else if (b < 0)
			s += "-" + -b;
		
		return s;
	}

}
