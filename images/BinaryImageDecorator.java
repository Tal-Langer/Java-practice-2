package images;

public abstract class BinaryImageDecorator implements Image {

	protected Image base1, base2;

	public BinaryImageDecorator(Image base1, Image base2) {
		this.base1 = base1;
		this.base2 = base2;
	}

	@Override
	public int getWidth() {
		return base1.getWidth() > base2.getWidth() ? base1.getWidth() : base2.getWidth();
	}

	@Override
	public int getHeight() {
		return base1.getHeight() > base2.getHeight() ? base1.getHeight() : base2.getHeight();
	}

	public RGB get(int x, int y) {
		if (point_in_image(x, y, base1))
			/* only base 1 define in (x,y) */
			return base1.get(x, y);

		else if (point_in_image(x, y, base2))
			/* only base 2 define in (x,y) */
			return base2.get(x, y);

		/* no image is define */
		return new RGB(0, 0, 0);// return black
	}

	protected boolean point_in_image(int x, int y, Image img) {
		if (img.getWidth() > x && img.getHeight() > y)
			return true;
		return false;
	}

}
