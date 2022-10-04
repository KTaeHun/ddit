package Shape;

public abstract class Shape implements Comparable<Shape> {
	
	public abstract double area();
	public abstract double perimeter();
	
	@Override
	public int compareTo(Shape o) {
		
		return 0;
	}
}
