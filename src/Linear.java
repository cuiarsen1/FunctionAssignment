import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Linear extends Quadratic implements Calculations, Drawable{

	public Linear(double a, double b, double x1) {
		super(0, a, b, x1);
	}
}
