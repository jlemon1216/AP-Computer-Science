
public class mathRunner extends newMath{

	public static void main(String[] args) {
		 newMath a = new newMath();
		 double[] r = new double[]{1, 2, 3, 4, 5, 6, 7};
		 System.out.println(a.pow(3, 2));
		 System.out.println(a.mod(8.5, 3));
		 System.out.println(a.divide(5, 10));
		 System.out.println(a.multiply(5, 10));
		 System.out.println(a.average(r));
		 System.out.println(a.multThree(8, 9, 10));
		 System.out.println(a.squareRoot(25));
	}
}
