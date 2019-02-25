import java.util.Scanner;    //columns must equal rows
public class matrix {

	public static void main(String[] args) {
		
		int[][] matrixA, matrixB;
		
		matrixA = new int[][] {
			{6, -2, 0},
			{7, 6 , 3},
			{4, 2, 0}
		};
		
		matrixB = new int[][] {
			{0, 2, 7, 8, 10},
			{1, 6, 7, 6, 3},
			{1, 4, 7, 4, 6},
		};
		
		int[][] finalMatrix = new int[matrixA.length][matrixB[0].length];
		for(int row = 0; row < finalMatrix.length; row++) {
			for(int column = 0; column < finalMatrix[row].length; column++) {
				finalMatrix[row][column] = getThing(matrixA[row], columnToArray(matrixB, column));
				System.out.print(finalMatrix[row][column]  + " ");
			
			}
			System.out.println();
		}
		
	}
	public void initializeArray(int[][] matrix) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter amount of rows.");
		int rows = s.nextInt();
		System.out.println("Enter amount of columns.");
		int columns = s.nextInt();
		
		matrix = new int[rows][columns];
		
	}
	public static int[] columnToArray(int[][] matrix, int column) {
		int[] array = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			array[i] = matrix[i][column];
		}
		return array;
	}
	public static int getThing(int[] arr1, int[] arr2){
		int sum = 0;
		for(int i = 0; i < arr1.length; i++){
			sum += arr1[i]*arr2[i];
			
		}
		return sum;
	}
}
