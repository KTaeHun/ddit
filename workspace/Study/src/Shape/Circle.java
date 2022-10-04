package Shape;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double perimeter() {
		return 2 * Math.PI * radius; 
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: 원, 둘레: %.2fcm, 넓이: %.2fcm^2", perimeter(), area());
	}
}

