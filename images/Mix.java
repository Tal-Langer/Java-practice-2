package images;

public class Mix extends BinaryImageDecorator {
	private double alpha;

	public Mix(Image base1, Image base2, double alpha) {
		super(base1, base2);
		this.alpha = alpha;
	}

	public RGB get(int x, int y) {
		if (point_in_image(x, y, base1) && point_in_image(x, y, base2))
			/* both images define in (x,y) */
			return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
		return super.get(x, y);
	}

	
}// class
