// Arsen Cui
// ICS4U1-01
// October 20, 2019
// Mr. Radulovic
// ICS4U1 Functions Inheritance Assignment

public interface Calculations 
{
	/**
	 * Returns the value of a function f at x
	 * @param x
	 * @return the value of a function f at x
	 */
	public double val(double x);
	
	
	/**
	 *
	 * @return true if the function is undefined.
	 */
	public boolean undefined(double x);
	
	// is undefined if f(x) equals positive or negative infinity. when something is divided by zero in java, the result is infinity???
	// is defined if within  current domain???
	
	/**
	 * Returns the area under a Function
	 * @param f - Function
	 * @param x_start - start of domain
	 * @param x_end - end of upper hand
	 * @return the area under a Function f from x = x_start to x = x_end
	 */
	public double getArea(double x_start, double x_end);
	
	
	/**
	 * Returns the slope of a Function at a certain point
	 * @param f - Function
	 * @param x - x-value at which to evaluate slope
	 * @return - slope of Function f evaluated at x
	 */
	public double getSlope(double x);
	
}
