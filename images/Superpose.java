package images;

public class Superpose extends BinaryImageDecorator {

	public Superpose(Image base1, Image base2) {
		super(base1, base2);
	}

	@Override
	public RGB get(int x, int y) {
		if (point_in_image(x, y, base1) && point_in_image(x, y, base2))
			/* both images define in (x,y) */
			return RGB.superpose(base1.get(x, y), base2.get(x, y));

		return super.get(x, y);
	}

}// class
