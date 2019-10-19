import javafx.scene.paint.Color;

/**
 * Complete the following base Function class.
 *
 */

//DO COLOUR AND NAME NEXT
public abstract class Function {
	
	// Variables representing the start and end domain of the function
	protected double x1;
	protected double x2;
	
	protected Color col;
	protected String name;
	protected double deltaX; // variable representing the amount to increment x by
	
	// Constructor method for the Function class.  The parameters represent the domain of the function.
	public Function(double x1, double x2) 
	{
		this.x1 = x1;
		this.x2 = x2;
		
		deltaX = 0.1;
	}
	
	// Returns a String containing the actual function.  For example, if the function was an object of the Parabola class, 
	// this method might return 2.0*(x - 4.0)^2 + 5.0.  There are spaces before and after the +, - operators only.
	public abstract String toString();
	
	// Sets the domain of this function to be between [x1, x2] where x2 > x1.
	public void setDomain(double x1, double x2)
	{
		this.x1 = x1;
		this.x2 = x2;
	}
	
	// Returns the starting value of the domain.
	public double getStartDomain()
	{
		return x1;
	}
	
	// Returns the ending value of the domain.
	public double getEndDomain()
	{
		return x2;
	}
	
	// Sets the drawing colour for this function.  The Color class is from JavaFX.
	public void setColour(Color col)
	{
		this.col = col;
	}
	
	// Returns the colour of this function.
	public Color getColour()
	{
		return col;
	}
	
	// Sets the name of this function type.
	public void setName(String name)
	{
		this.name = name;
	}
	
	// Returns the name of this function type as a String.
	public String getName()
	{
		return name;
	}
}
