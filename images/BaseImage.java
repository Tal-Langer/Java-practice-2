package images;

public abstract class BaseImage implements Image {
	protected int width, height;

	public BaseImage(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public abstract RGB get(int x, int y);

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
