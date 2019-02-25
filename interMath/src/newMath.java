
public class newMath implements interMath {

	public double mod(double x, double y) {
		double i = 0;
		int prod = 0;
		prod = (int)(x / y);
		i = (x - (prod*y));
		
		return i;
	}
	public double pow(double x, int y) {
		int ans = 1;
		for(int i = 0; i <= y; i++) {
			ans *= x;
		}
		return ans;
	}

	public double multiply(double x, double y){
		double i = x*y;
		return i;
	}
	public double divide(double x, double y) {
		return x/y;
	}
	public double average(double[] z) {
		double av = 0;
		for(int i = 0; i < z.length; i++) {
			av += z[i];
		}
		return av /= z.length;
	}
	public double multThree(double x, double y, double z) {
		return x*y*z;
	}
	public double squareRoot(double x){
		return Math.sqrt(x);
	}
}
