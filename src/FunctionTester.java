import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
		
		Line axisX = new Line(0, canvas.getHeight()/2, canvas.getWidth(), canvas.getHeight()/2);
		Line axisY = new Line(canvas.getWidth()/2, 0, canvas.getWidth()/2, canvas.getHeight());
		axisX.setStrokeWidth(2);
		axisY.setStrokeWidth(2);
		
		root.getChildren().addAll(axisX, axisY);

		Linear l = new Linear(1, 0, 0);
		Arc a = new Arc(4, 0, -2);
		Logarithm log = new Logarithm(1, 0, 0);
		Quadratic q = new Quadratic(1, 0, 0, 0);
		Cubic c = new Cubic(0.35, 0.25, -0.5, -1, 2);
		Parabola p = new Parabola(1, 0, 0);

		//PRINT AREA AND SLOPE HERE
		
//		l.setDomain(-200, 400);
//		l.setName("Linear");
//		l.setColour(Color.BLACK);
//		l.draw(canvas);
//
//		a.setDomain(-300, 300);
//		a.setName("Arc");
//		a.setColour(Color.BLUE);
//		a.draw(canvas);
//
//		log.setDomain(-300, 300);
//		log.setName("Logarithm");
//		log.setColour(Color.RED);
//		log.draw(canvas);
//
//		q.setDomain(-300, 300);
//		q.setName("Quadratic");
//		q.setColour(Color.BROWN);
//		q.draw(canvas);
//
//		c.setDomain(-300, 300);
//		c.setName("Cubic");
//		c.setColour(Color.LIME);
//		c.draw(canvas);
//
		p.setDomain(-300, 300);
		p.setName("Parabola");
		p.setColour(Color.PURPLE);
		p.draw(canvas);

		
	 /* System.out.println(a.getArea(-1 , 1)); System.out.println(q.getSlope(0));
	  
	  System.out.println(l.toString()); System.out.println(a.toString());
	  System.out.println(log.toString()); System.out.println(q.toString());
	  System.out.println(c.toString()); System.out.println(p.toString());*/
		
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	// test method for drawing - you can use this as an example for drawing various
	// types of lines
	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		gc.strokeLine(40, 10, 10, 40);

		gc.strokePolygon(new double[] { 60, 90, 60, 90 }, new double[] { 210, 210, 240, 240 }, 4);
		gc.strokePolyline(new double[] { 110, 140, 110, 140 }, new double[] { 210, 210, 240, 240 }, 4);
	}

}
