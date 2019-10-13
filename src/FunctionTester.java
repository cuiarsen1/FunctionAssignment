import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Example of using the Canvas and GraphicsContext class within JavaFX
 *
 */

public class FunctionTester extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Drawing Functions Test");
		Group root = new Group();
		Canvas canvas = new Canvas(600, 600);
		
		Linear l = new Linear(1, 0, 0);
		Arc a = new Arc(1, 0, 0);
		Logarithm log = new Logarithm(1, 0, 0);
		Quadratic q = new Quadratic(1, 0, 0, 0);
		Cubic c = new Cubic(1, 0, 0, 0, 0);
		Parabola p = new Parabola(1, 0, 0);
		
		l.setDomain(200, 400);
		System.out.println(a.getArea(-1 , 1));
		System.out.println(q.getSlope(0));
		
		System.out.println(l.toString());
		System.out.println(a.toString());
		System.out.println(log.toString());
		System.out.println(q.toString());
		System.out.println(c.toString());
		System.out.println(p.toString());
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//System.out.println(l.getName());
		//l.draw(gc, f);
		//drawShapes(gc);
		root.getChildren().add(canvas);
		//primaryStage.setScene(new Scene(root));
		//primaryStage.show();

	}

	// test method for drawing - you can use this as an example for drawing various types of lines
	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		gc.strokeLine(40, 10, 10, 40);

		gc.strokePolygon(new double[]{60, 90, 60, 90},
				new double[]{210, 210, 240, 240}, 4);
		gc.strokePolyline(new double[]{110, 140, 110, 140},
				new double[]{210, 210, 240, 240}, 4);
	}

}
