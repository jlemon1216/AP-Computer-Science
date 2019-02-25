
public class MultiD {

    public static void print1D(int[] x) {

   	 for (int i = 0; i < x.length; i++) {
   		 System.out.print(x[i] + " ");
   	 }
   	 
    }
    public static void print1D(String[] x) {

   	 for (int i = 0; i < x.length; i++) {
   		 System.out.print(x[i] + " ");
   	 }
   	 
    }

    public static void print2D(int[][] x) {
   	 for (int i = 0; i < x.length; i++) {
   		 for (int c = 0; c < x[i].length; c++) {
   			 System.out.print(x[i][c] + " ");
   		 }
   	 }
    }
    
    public static void print2D(String[][] x) {
   	 for (int i = 0; i < x.length; i++) {
   		 for (int c = 0; c < x[i].length; c++) {
   			 System.out.print(x[i][c] + " ");
   		 }
   	 }
    }

    public static int[][] compileArrays(int[] x, int[] y, int[] z) {

   	 int[][] big = new int[3][];

   	 big[0] = x;
   	 big[1] = y;
   	 big[2] = z;

   	 return big;
    }

    public static String[][] evenArray(String[][] words) {
   	 int shortestLength = words[0].length;

   	 for (int i = 0; i < words.length; i++) {
   		 for (int x = 0; x < words[i].length; x++) {
   			 if (words[i].length < shortestLength)
   				 shortestLength = words[i].length;
   		 }
   	 }
   	 String[][] combo = new String[words.length][shortestLength];

   	 for (int z = 0; z < combo.length; z++) {
   		 for (int y = 0; y < combo[z].length; y++) {
   			 combo[z][y] = words[z][y];
   		 }
   	 }
   	 return combo;

    }

    public static boolean stringLength(int[] lens, String[][] words) {
   	 evenArray(words);
   	 int counter = 0;
   	 for (int i = 0; i < words.length; i++) {
   		 for (int x = 0; x < words[i].length; x++) {
   			 if (words[i][x].length() == lens[x])
   				 counter++;
   		 }
   	 }
   	 if (counter == words[0].length*words.length)
   		 return true;
   	 return false;

    }

    public static int[] thirdCol(int[][] nums) {

   	 int[] third = new int[nums.length];

   	 for (int i = 0; i < nums.length; i++) {
   		 third[i] = nums[i][2];
   	 }
   	 return third;
    }

    public static boolean dupes(String[] x) {
    	for (int i = 0; i < x.length; i++)
			for (int j = 0; j < i; j++)
				if (j == i)
					continue;
				else if (x[i] == x[j])
					return true;
		return false;

    }

    public static boolean multiDupes(String[][] x) {
    	for (int i = 0; i < x.length; i++)
			for (int j = 0; j < x[i].length; j++)
				for (int k = 0; k < x.length; k++)
					for (int l = 0; l < x[k].length; l++)
						if (j == l && i == k)
							continue;
						else if (x[i][j] == x[k][l])
							return true;
		return false;
  
    }

    public static int[][] noEvens(int[][] nums) {

   	 for (int i = 0; i < nums.length; i++) {
   		 for (int x = 0; x < nums[i].length; x++) {
   			 if (nums[i][x] % 2 == 0) {
   				 nums[i][x] = 5;
   			 }
   		 }
   	 }
   	 return nums;

    }
}



