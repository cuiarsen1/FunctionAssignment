import javafx.scene.canvas.GraphicsContext;

public class Parabola extends Quadratic implements Calculations, Drawable {

	protected double a, b, x1;
	
	public Parabola(double a, double b, double x1) {
		
		super(a, 0, b, x1);
		
		this.a = a;
		this.b = b;
		this.x1 = x1;
	}

	@Override
	public void draw(GraphicsContext gc, Function f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double val(double x) {
		
		double y = a*Math.pow(x - x1, 2) + b;
		
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
		double deltaX = 0.1;
		double slope = (val(x + deltaX) - val(x - deltaX))/(2*deltaX);
		
		return slope;
	}
	
	@Override
	public String toString() {

		String s = "";
		
		return s;
	}

}
