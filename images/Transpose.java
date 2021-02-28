package images;

public class Transpose extends ImageDecorator {

	public Transpose(Image base) {
		super(base);
	}

	@Override
	public int getWidth() {
		return base.getHeight();
	}

	@Override
	public int getHeight() {
		return base.getWidth();
	}

	@Override
	public RGB get(int x, int y) {
		return base.get(y, x);
	}

	public static void main(String[] args) {

		Image i2 = new Transpose(new Gradient(100, 200, RGB.BLUE, RGB.GREEN));
		Displayer.display(i2);

	}

}
