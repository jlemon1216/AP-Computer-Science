import java.util.Scanner;
public class DistTester {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter an A value");
   	 DistToLine.A = s.nextDouble();
   	 System.out.println("Enter a B value");
   	 DistToLine.B = s.nextDouble();
   	 System.out.println("Enter a C value");
   	 DistToLine.C = s.nextDouble();
   	 System.out.println("Enter an x coordinate");
   	 double x = s.nextDouble();
   	 System.out.println("Enter a y coordinate");
   	 double y = s.nextDouble();
   	System.out.println(DistToLine.getDist(x, y));
   	 
    }
}
