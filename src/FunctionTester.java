// Arsen Cui
// ICS4U1-01
// October 20, 2019
// Mr. Radulovic
// ICS4U1 Functions Inheritance Assignment

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class FunctionTester extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Drawing Functions Test");
		Group root = new Group();
		Canvas canvas = new Canvas(600, 600);

		Linear l = new Linear(4, 0, 0);
		Arc a = new Arc(1, 0, 0);
		Logarithm log = new Logarithm(1, 0, 0);
		Quadratic q = new Quadratic(1, 0, 0, 0);
		Cubic c = new Cubic(0.35, 0.25, -0.5, -1, 2);
		Parabola p = new Parabola(1, 0, 0);

		//		l.setDomain(-200, 400);
		//		l.setName("Linear");
		//		l.setColour(Color.BLACK);
		//		l.draw(canvas);
		//
		//		a.setDomain(-10, 10);
		//		a.setName("Arc");
		//		a.setColour(Color.BLUE);
		//		a.draw(canvas);
		//
		//		log.setDomain(0, 300);
		//		log.setName("Logarithm");
		//		log.setColour(Color.RED);
		//		log.draw(canvas);
		//
		//		q.setDomain(200, 300);
		//		q.setName("Quadratic");
		//		q.setColour(Color.BROWN);
		//		q.draw(canvas);
		//
		//		c.setDomain(-200, 400);
		//		c.setName("Cubic");
		//		c.setColour(Color.LIME);
		//		c.draw(canvas);
		//
		//		p.setDomain(-300, 300);
		//		p.setName("Parabola");
		//		p.setColour(Color.PURPLE);
		//		p.draw(canvas);

		System.out.println(a.getArea(-1, 1));
		System.out.println(q.getSlope(1));

		System.out.println(l.toString());
		System.out.println(a.toString());
		System.out.println(log.toString());
		System.out.println(q.toString());
		System.out.println(c.toString());
		System.out.println(p.toString());

		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

}
