package images;

public class RGB {
	double red, green, blue;

	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	public RGB(double red, double green, double blue) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public RGB(double grey) {
		this.red = grey;
		this.blue = grey;
		this.green = grey;
	}

	public double getRed() {
		return red;
	}

	public double getBlue() {
		return blue;
	}

	public double getGreen() {
		return green;
	}

	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	public RGB filter(RGB filter) {
		return new RGB(red * filter.getRed(), green * filter.getGreen(), blue * filter.getBlue());
	}

	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double r, g, b;
		r = rgb1.getRed() + rgb2.getRed();
		g = rgb1.getGreen() + rgb2.getGreen();
		b = rgb1.getBlue() + rgb2.getBlue();

		r = r < 1 ? r : 1;// secure range lower than 1
		g = g < 1 ? g : 1;
		b = b < 1 ? b : 1;

		return new RGB(r, g, b);
	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double r, g, b;
		r = alpha * rgb1.getRed() + (1 - alpha) * rgb2.getRed();
		g = alpha * rgb1.getGreen() + (1 - alpha) * rgb2.getGreen();
		b = alpha * rgb1.getBlue() + (1 - alpha) * rgb2.getBlue();
		return new RGB(r, g, b);
	}

	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}

}//class
