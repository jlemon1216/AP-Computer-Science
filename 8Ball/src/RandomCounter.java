import java.util.Random;

public class RandomCounter {

	public static void main(String[] args) {
		
		Random rand = new Random(10);
		int[] x = new int[10];
		for(int i = 0; i < 10000; i++){
			x[rand.nextInt(10)]++; 
		}
		for(int i = 0; i < x.length; i++){
			System.out.println(x[i]);
		}
	}
}
