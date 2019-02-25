/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	// public static void testZeroBlue() {
	// Picture beach = new Picture("beach.jpg");
	// beach.explore();
	// beach.zeroBlue();
	// beach.explore();
	// }

	public static void testZeroRed() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroRed();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("twolegcat.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	public static void convertToBlackAndWhite() {
		Picture pic = new Picture("kitten2.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixel : row) {
				int average = (int) pixel.getAverage();
				pixel.setRed(average);
				pixel.setBlue(average);
				pixel.setGreen(average);
			}
		}
		pic.explore();
	}

	public static void adjustBrightness(double d) {
		Picture pic = new Picture("koala.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixel : row) {
				pixel.setBlue((int) (pixel.getBlue() * d));
				pixel.setGreen((int) (pixel.getGreen() * d));
				pixel.setRed((int) (pixel.getRed() * d));
			}

		}
		pic.explore();
	}

	public static void adjustBrightness2(double d) {
		Picture pic = new Picture("koala.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixel : row) {
				double br = d;
				double brightest = Math.max(Math.max(pixel.getGreen(), pixel.getBlue()), pixel.getRed());
				if (brightest * d > 255) {
					br = 255.0 / brightest;
				}
					pixel.setBlue((int) (pixel.getBlue() * br));
					pixel.setGreen((int) (pixel.getGreen() * br));
					pixel.setRed((int) (pixel.getRed() * br));
			}

		}
		pic.explore();

	}
	public static void horizontalMirrored() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for(int colm = 0; colm < pixels[row].length; colm++) {
				pixels[row][pixels[row].length - 1 - colm].setGreen(pixels[row][colm].getGreen());
				pixels[row][pixels[row].length - 1 - colm].setBlue(pixels[row][colm].getBlue());
				pixels[row][pixels[row].length - 1 - colm].setRed(pixels[row][colm].getRed());
				
			}
		}
		pic.explore();
	}
	public static void verticalMirrored() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for(int colm = 0; colm < pixels[row].length; colm++) {
				pixels[pixels.length - 1 - row][colm].setGreen(pixels[row][colm].getGreen());
				pixels[pixels.length - 1 - row][colm].setBlue(pixels[row][colm].getBlue());
				pixels[pixels.length - 1 - row][colm].setRed(pixels[row][colm].getRed());
				
			}
		}
		pic.explore();
	}
	public static void horizontalFlip() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for(int colm = 0; colm < pixels[row].length/2; colm++) {
				int green = pixels[row][colm].getGreen();
				int blue = pixels[row][colm].getBlue();
				int red = pixels[row][colm].getRed();
				
				pixels[row][colm].setGreen(pixels[row][pixels[row].length - 1 - colm].getGreen());
				pixels[row][colm].setBlue(pixels[row][pixels[row].length - 1 - colm].getBlue());
				pixels[row][colm].setRed(pixels[row][pixels[row].length - 1 - colm].getRed());
				pixels[row][pixels[row].length - 1 - colm].setGreen(green);
				pixels[row][pixels[row].length - 1 - colm].setBlue(blue);
				pixels[row][pixels[row].length - 1 - colm].setRed(red);
			}
		}
		pic.explore();
	}
	public static void verticalFlip() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length/2; row++) {
			for(int colm = 0; colm < pixels[row].length; colm++) {
				int green = pixels[row][colm].getGreen();
				int blue = pixels[row][colm].getBlue();
				int red = pixels[row][colm].getRed();
				
				pixels[row][colm].setGreen(pixels[pixels.length - 1 - row][colm].getGreen());
				pixels[row][colm].setBlue(pixels[pixels.length - 1 - row][colm].getBlue());
				pixels[row][colm].setRed(pixels[pixels.length - 1 - row][colm].getRed());
				pixels[pixels.length - 1 - row][colm].setGreen(green);
				pixels[pixels.length - 1 - row][colm].setBlue(blue);
				pixels[pixels.length - 1 - row][colm].setRed(red);
			}
		}
		pic.explore();
	}
	public static void repairTemple() {
		Picture pic = new Picture("temple.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for(int row = 0; row <= 96; row++){
			for(int colm = 0; colm < 275; colm++) {
				pixels[row][550 - colm].setGreen(pixels[row][colm].getGreen());
				pixels[row][550 - colm].setBlue(pixels[row][colm].getBlue());
				pixels[row][550 - colm].setRed(pixels[row][colm].getRed());
				
			}
		}
		pic.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		//adjustBrightness2(6);
		//horizontalMirrored();
		//repairTemple();
		//verticalMirrored();
		//horizontalFlip();
		//verticalFlip();
		//horizontalMirrored();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		testCollage();
		// testCopy();
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
}