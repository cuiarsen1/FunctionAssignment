import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Quadratic extends Cubic implements Calculations, Drawable {
	
	public Quadratic(double a, double b, double c, double x1) {
		super(0, a, b, c, x1);
	}

}
