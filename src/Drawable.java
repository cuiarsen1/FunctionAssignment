import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface Drawable 
{
	/**
	 * Draws the given function to the JavaFX graphics context (screen)
	 */
	public void draw(Canvas c);

}
