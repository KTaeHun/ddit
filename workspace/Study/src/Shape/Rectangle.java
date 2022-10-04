package Shape;

public class Rectangle extends Shape{
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double perimeter() {
		return 2 * (width + height); 
	}
	
	public double area() {
		return width * height;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: 사각형, 둘레: %.2fcm, 넓이: %.2fcm^2", perimeter(), area());
	}
}
