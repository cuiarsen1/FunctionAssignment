import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Arc extends Function implements Calculations, Drawable{
	
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
		// TODO Auto-generated method stub
		
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
		
		double deltaX = 0.001;
		double currentX = x_start;
		double area = 0;
		
			while (currentX < x_end)
			{
				if (undefined(currentX) == false)
				{
					area += val(currentX) * deltaX;
					
					currentX += deltaX;
				
				}else
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
		
		s += "sqrt(";
		
		if (r == 0)
			s += "-";
		else
			s += "(" + r + ")^2-";
		
		if (xcenter == 0)
			s += "(x)^2)";
		else if (xcenter > 0)
			s += "(x - " + xcenter + ")^2)";
		else 
			s += "(x + " + -xcenter + ")^2)";
		
		if (ycenter == 0)
			return s;
		else if (ycenter > 0)
			s += " + " + ycenter;
		else
			s += " - " + -ycenter;
		
		return s;
		
	}

}
