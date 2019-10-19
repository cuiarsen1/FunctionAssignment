// Arsen Cui
// ICS4U1-01
// October 20, 2019
// Mr. Radulovic
// ICS4U1 Functions Inheritance Assignment
/*This program represents the inheritance tree of different types of mathematical functions. Given 
values for each of the variables in each type of function, the program will be able to draw the
function on a GUI interface, as well as print out the equation of the function, the name of the 
function, the area underneath the function, and the slope of the function at any given point.*/

import javafx.scene.paint.Color;

public abstract class Function implements Calculations, Drawable {
	
	// Variables representing the start and end domain of the function
	protected double x1;
	protected double x2;
	
	//Variables representing the colour and name of the function
	protected Color col;
	protected String name;
	
	protected double deltaX; // Variable representing the amount to increment x by
	
	public Function(double x1, double x2) 
	{
		this.x1 = x1;
		this.x2 = x2;
		
		deltaX = 0.1;
	}
	
	// Method used to return the equation of the function as a string
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
	
	// Sets the drawing colour for this function.
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
