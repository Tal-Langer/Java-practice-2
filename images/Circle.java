package images;

public class Circle extends BaseImage {

	private int centerX, centerY, radius;
	private RGB center, outside;

	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size);
		this.radius = radius;
		this.center = center;
		this.outside = outside;
		/* center of circle is center of image */
		this.centerX = size / 2;
		this.centerY = size / 2;
	}

	public RGB get(int x, int y) {

		double distance, relation;
		double x_pow, y_pow;
		x_pow = x - centerX;
		x_pow = Math.pow(x_pow, 2);
		y_pow = y - centerY;
		y_pow = Math.pow(y_pow, 2);
		distance = Math.sqrt(x_pow + y_pow);

		relation = distance / radius;
		relation = relation < 1 ? relation : 1;// secure relation lower than 1
		return RGB.mix(outside, center, relation);

	}

	public static void main(String[] args) {
		Image i = new Circle(200, 100, 70, 70, 90, RGB.BLUE, new RGB(0.5, 0, 0.5));
		Displayer.display(i);

	}

}
